import Models.PriceObject;
import Models.Race;
import Models.Table;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JSONParsing {
    /**
     * Класс JSONParsing выполняет несколько задач
     * 1) Передаёт имя файла в синг класс ReadFile
     * 2) Парсится файл, была подключена для этого библиотека json.org через maven. Для быстроты использовал Stream
     * 3) Создаются списки с типами: Object, PriceObject, Race, Table. Что в этих моделях хранятся посмотрите глубже
     * папки java/Models
     * */


    public JSONObject getJSONObjectFiles(){
        return new JSONObject(ReadFile.getInstance("rules.json").readFileFromAssets());
    }

    public List<Race> getListRace(){
        List<Race> raceList = new ArrayList<>();
        JSONArray jsonArrayRace = new JSONArray(getJSONObjectFiles().get("Race").toString());
        for(String row : jsonArrayRace.getJSONObject(0).keySet()){
            int id = Integer.parseInt(
                    String.valueOf(
                            jsonArrayRace.getJSONObject(0)
                                    .getJSONObject(row)
                                    .getString("id")
                    )
            );
            raceList.add(new Race(id,row));
        }
        return raceList;
    }

    public List<Table> getListTable(){
        List<PriceObject> priceObjectList;
        List<Table> tableList = new ArrayList<>();

        JSONArray jsonArrayObject = new JSONArray(getJSONObjectFiles().get("Objects").toString());
        JSONArray jsonArrayPriceObject = new JSONArray(getJSONObjectFiles().get("PriceObject").toString());

        for (Object id : getListRace().stream().map(e -> e.getId().toString()).toArray()){
            priceObjectList = new ArrayList<>();
            for (int i = 0; i < jsonArrayObject.length(); i++){
                String objectName = jsonArrayObject.get(i).toString();

                Integer price = Integer.parseInt(
                        jsonArrayPriceObject.getJSONObject(0)
                                .getJSONArray(id.toString())
                                .get(i)
                                .toString()
                );
                priceObjectList.add(new PriceObject(objectName,price));
            }
            tableList.add(new Table(Integer.parseInt(id.toString()), priceObjectList));
        }
        return tableList;
    }

    /**
     * В этот метод входит 2 параметра: Какая раса(человек, болотни, леший) и список символов
     * @param race,
     * @param arrWords
     * @return List<Integer>
     * */

    public List<Integer> getListPrice(String race, char[] arrWords){
        List<Integer> listPrice = new ArrayList<>();

        Integer idRace = getListRace().stream()
                .filter(o -> o.getRaceName().equals(race))
                .findFirst()
                .get()
                .getId();

        List<PriceObject> priceObjectList = getListTable().stream()
                .filter(table -> table.getIdRace().equals(idRace))
                .findFirst()
                .get()
                .getPriceObject();
        for (char arrWord : arrWords) {
            for (PriceObject priceObject : priceObjectList) {
                if (Objects.equals(priceObject.getObject(), String.valueOf(arrWord))) {
                    listPrice.add(priceObject.getPrice());
                }
            }
        }
        return listPrice;
    }
}
