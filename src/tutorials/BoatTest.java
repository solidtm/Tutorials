package tutorials;

import static org.junit.Assert.*;

public class BoatTest {

    Boat b = new Boat();

    @org.junit.Test
    public void testDriveFunctionWithNonEmptyEngineReturnsRequiredResult() {
        int[] engine = new int[]{1,2,3};

        String result = b.drive(engine);
        String expectedResult = "The boat has an engine of " + engine[0] + "hp and is sailing on the sea";

        assertEquals(result, expectedResult);
    }

    @org.junit.Test
    public void testDriveFunctionWithEmptyEngineReturnsRequiredResult() {
        int[] engine = new int[]{};

        String result = b.drive(engine);
        String expectedResult = "Invalid array please pass in a valid array";

        assertEquals(result, expectedResult);
    }
}