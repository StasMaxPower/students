package service;

public class StringService {

    public static String convertIdsIntoString(String[] ids){
        StringBuilder result = new StringBuilder();
        for (String id : ids) { //   '1','3','5',
            result.append("'").append(id).append("', ");
        }
        result.setLength(result.length()-2);
        return result.toString();
    }
}
