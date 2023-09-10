package lk.ijse.util;

public class GenerateId {
    public static String setId(String id){
        String prefix = id.replaceAll("[0-9]", "");
        int number = Integer.parseInt(id.replaceAll("\\D", ""));
        number++;
        String newNumber = String.format("%0" + (id.length() - prefix.length()) + "d", number);
        return prefix+newNumber;
    }
}
