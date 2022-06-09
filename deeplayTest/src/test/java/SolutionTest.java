import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void invalidTest(){
        try {
            Solution.getResult("WESADPWAF","Human");
            Assert.fail();
        }catch (IllegalArgumentException ex){
            Assert.assertEquals("You got an error Exception: exceeded length characters", ex.getMessage());
        }
        String race = "Humans";
        try {
            Solution.getResult("WESADPWAF",race);
            Assert.fail();
        }catch (IllegalArgumentException ex){
            Assert.assertEquals(String.format("You got an error Exception: this race %s don't found", race), ex.getMessage());
        }
    }

    @Test
    public void humanTest(){
        Integer resultRoute = Solution.getResult("STWSWTPPTPTTPWPP", "Human");
        Assert.assertEquals(java.util.Optional.ofNullable(10), java.util.Optional.ofNullable(resultRoute));
    }

    @Test
    public void swamperTest(){
        Integer resultRouteOne = Solution.getResult("TTTTTTTTTTTTTTTT", "Swamper");
        Assert.assertEquals(java.util.Optional.ofNullable(30), java.util.Optional.ofNullable(resultRouteOne));

        Integer resultRouteTwo = Solution.getResult("WSPWSPWSPWSPWSPS", "Swamper");
        Assert.assertEquals(java.util.Optional.ofNullable(12), java.util.Optional.ofNullable(resultRouteTwo));
    }

    @Test
    public void woodmanTest(){
        Integer resultRoute = Solution.getResult("WTWTWTWTWTWTWTWT", "Woodman");
        Assert.assertEquals(java.util.Optional.ofNullable(13), java.util.Optional.ofNullable(resultRoute));
    }
}
