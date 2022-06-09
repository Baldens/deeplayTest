import Models.Race;

import java.util.List;

public class Solution {
    public static Integer getResult(String fields, String race) {
        JSONParsing jsonParsing = new JSONParsing();
        if(jsonParsing.getListRace().stream().noneMatch(race1 -> race1.getRaceName().equals(race))){
            throw new IllegalArgumentException(String.format("You got an error Exception: this race %s don't found", race));
        }
        if(fields.length() == 16){

            char[] arrWords = fields.toCharArray();
            List<Integer> listPrice = jsonParsing.getListPrice(race, arrWords);
            int[][] field = new int[4][4];

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(i == 0 && j == 0){
                        field[i][j] = 0;
                    }else{
                        field[i][j] = listPrice.get(4*i+j);
                    }
                }
            }

            ControllerSearchShortRoute controllerSearchRoute = new ControllerSearchShortRoute(field);
            return controllerSearchRoute.getBestSum();
        }else{
            throw new IllegalArgumentException("You got an error Exception: exceeded length characters");
        }
    }
}
