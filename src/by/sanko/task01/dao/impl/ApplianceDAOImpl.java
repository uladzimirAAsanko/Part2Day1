package by.sanko.task01.dao.impl;

import by.sanko.task01.dao.ApplianceDAO;
import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.exception.DAOException;
import by.sanko.task01.service.ApplianceCreator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String RESOURCE_NAME = "resources.property.file";
    private static final String FILE_NAME = "filename";
    private static final String FILE_PATH = "path";
    private static final String FILE_CONFIG = "config";
    private static final String SPACE = " ";
    private static final String END_LINE = "\n";
    private static final String PATH_TO_RESOURCES = "resources";

    @Override
    public List<Appliance> find(Criteria criteria) throws DAOException {
        List<Appliance> result = new ArrayList<>();
        String pathOutput = getPath();
        String filePath = pathOutput.substring(0,pathOutput.indexOf(' '));
        String fileName = pathOutput.substring(pathOutput.indexOf(' ') + 1);

        try(BufferedReader database = new BufferedReader(new FileReader(filePath + "/" + fileName))) {
            int numberOfLine = findNeededLine(criteria.getGroupSearchName(), fileName);
            for(int i = 1; i < numberOfLine; i++){
                database.readLine();
            }
            ApplianceCreator creator = new ApplianceCreator();

            String line = database.readLine();
            while(!line.isEmpty() && line != null){
                AtomicBoolean isItOur = new AtomicBoolean(true);
                String finalLine = line;

                criteria.getCriteria().forEach((name, data)->{
                    if(isItOur.get()) {
                        int posOfName = finalLine.indexOf(name);
                        int posOfDelimeter = finalLine.indexOf(',', posOfName);
                        if (posOfDelimeter == -1) {
                            posOfDelimeter = finalLine.length();
                        }
                        String searchArea = finalLine.substring(posOfName, posOfDelimeter);
                        searchArea = searchArea.substring(searchArea.indexOf('=') + 1);
                        if (!searchArea.equals("" + data)) { // так делать если закидываем примитивные классы, если обертки то toString нужно делать
                            isItOur.set(false);
                        }
                    }
                });

                if(isItOur.get()){
                    result.add(creator.create(line));
                }
                line = database.readLine();
            }

        }catch (IOException e){
            throw new DAOException(e.getMessage());
        }
        return result;
    }

    private String getPath() throws DAOException {
        try {
            ResourceBundle res = ResourceBundle.getBundle(RESOURCE_NAME);
            String filePath = res.getString(FILE_PATH);
            String fileName = res.getString(FILE_NAME);
            String path = "";
            if(Files.exists(Paths.get(filePath, fileName))) {
                path = filePath +" " + fileName;
            } else {
                throw new DAOException("File does not exist");
            }
            if(!Files.exists(Paths.get(PATH_TO_RESOURCES,FILE_CONFIG+fileName))){
                describeFile(filePath,fileName);
            }
            return path;
        } catch (MissingResourceException e) {
            throw new DAOException("ResourceBundle does not exist", e);
        }
    }

    private void describeFile(String filePath, String fileName) throws DAOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(PATH_TO_RESOURCES + "/" + FILE_CONFIG+  fileName));
            BufferedReader reader = new BufferedReader(new FileReader(filePath+"/" + fileName))){

            String line = "";
            int countOfLines = 1;
            String word = "";
            while((line = reader.readLine()) != null){
                if(!line.isEmpty()){
                    int posOfSpace = line.indexOf(' ');
                    if(!word.equals(line.substring(0,posOfSpace))){
                        word = line.substring(0,posOfSpace);
                        StringBuilder builder = new StringBuilder();
                        builder.append(word).append(SPACE).append(countOfLines).append(END_LINE);
                        fileOutputStream.write(builder.toString().getBytes());
                    }

                }
                countOfLines++;
            }
        } catch (IOException e) {
            throw new DAOException("Error in description of file " + fileName);
        }
    }

    private int findNeededLine(String criteria, String fileName) throws DAOException {
        int numberOfLine = -1;
        try(BufferedReader config = new BufferedReader(new FileReader(PATH_TO_RESOURCES + "/" + FILE_CONFIG+  fileName))) {

            String inputLine = "";
            while ((inputLine = config.readLine()) != null) {
                int posOfSpace = inputLine.indexOf(' ');
                if (criteria.equals(inputLine.substring(0, posOfSpace))) {
                    numberOfLine = Integer.parseInt(inputLine.substring(posOfSpace + 1));
                    break;
                }
            }
            if (numberOfLine == -1) {
                throw new DAOException("Cannot find this type of Appliance in Storage");
            }
        }catch (IOException e){
            throw new DAOException(e.getMessage());
        }
        return numberOfLine;
    }
}
