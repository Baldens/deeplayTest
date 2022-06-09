import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ControllerSearchShortRouteTest {
    @Test
    public void testArrayField(){
        ControllerSearchShortRoute searchShortRoute;
        try {
            int[][] array = new int[5][4];
            searchShortRoute = new ControllerSearchShortRoute(array);
            Assert.fail();
        }catch (IllegalArgumentException exception){
            Assert.assertEquals("Error length array", exception.getMessage());
        }

        int[][] array = {{2,3,4,5},{1,3,5,2},{2,2,4,2},{2,3,1,5}};
        searchShortRoute = new ControllerSearchShortRoute(array);
        Assert.assertEquals(Optional.ofNullable(searchShortRoute.getBestSum()),Optional.of(22));
    }
}
