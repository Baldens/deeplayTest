import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileTest {
    @Test
    public void isNameFileTest(){
        try {
            ReadFile.getInstance("rules.json").readFileFromAssets();
            Assert.fail();
        }catch (Exception exception){
            Assert.assertEquals("Файл не был найден: rules.jso (Не удается найти указанный файл)", exception.getMessage());
        }
    }
}
