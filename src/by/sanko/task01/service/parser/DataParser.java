package by.sanko.task01.service.parser;

public class DataParser {
    private static  DataParser instance;

    private DataParser(){}

    public static DataParser getInstance(){
        if(instance == null){
            instance = DataParser.getInstance();
        }
        return instance;
    }

    public String parseValue(String input){
        int posOfEqual = input.indexOf('=');
        int posOfDelim = input.indexOf(',');
        if(posOfDelim == -1){
            posOfDelim = input.length();
        }
        return input.substring(posOfEqual + 1,posOfDelim);
    }
}
