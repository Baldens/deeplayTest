import org.json.JSONObject;

import javax.naming.Context;
import java.io.*;

public class ReadFile {
    /**
     * Данный класс является выполнением некоторых действий:
     * 1) Чтение файла, в котором передаётся в getInstance название файла json в проекте
     * 2) Возвращает в типе String результат чтения. Отвечает за это метод readFileFromAssets()
     * Данный класс используется в одном классе - JSONParsing.java
     * */

    private static ReadFile INSTANCE;
    private static String fileName;

    private ReadFile(String fileName){
        this.fileName = fileName;
    }

    /**
     * @param fileName
     * @return INSTANCE
     * */

    public static ReadFile getInstance(String fileName){
        if(INSTANCE == null){
            INSTANCE = new ReadFile(fileName);
        }
        return INSTANCE;
    }

    /**
     * @return String
     * */

    public String readFileFromAssets() {

        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            return builder.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Файл не был найден: " + e.getMessage());
                }
            }
        }
        return null;
    }
}
