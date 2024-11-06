package tutorials;

import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,3,3,5,5};
        Test test = new Test();
        int[] distinctArr =  test.removeDuplicates(nums);
        double mean = test.getMean(distinctArr);
        double stdDev = test.getStdDev(distinctArr);

        System.out.println(Arrays.toString(distinctArr));
        System.out.println(mean);
        System.out.println(stdDev);
    }

}
