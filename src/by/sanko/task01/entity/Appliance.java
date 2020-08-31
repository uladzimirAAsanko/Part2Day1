package by.sanko.task01.entity;

public class Appliance {
    protected static String parseValue(String input){
        int posOfEqual = input.indexOf('=');
        int posOfDelim = input.indexOf(',');
        if(posOfDelim == -1){
            posOfDelim = input.length();
        }
        return input.substring(posOfEqual + 1,posOfDelim);
    }
}
