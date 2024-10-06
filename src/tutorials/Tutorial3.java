package tutorials;

import java.util.Arrays;

public class Tutorial3 {
    public static void main(String[] args) {
        /**
         *
         * Let’s write a really quick program to do the following:
         * • Generate some number of random integers
         * • Calculate the mean of those integers
         * • Calculate the median of those integers
         * • Identify those members that are ‘above average’ ( >mean)
         *
         * */

//                                 0                     8
        int[] intArray = new int[]{29,3,1,5,45,27,32,89,50};
        int mean, median, sum = 0;
        int start = 0, end = intArray.length - 1;
        StringBuilder numbersAboveAvg = new StringBuilder();

        //Calculate mean
        for(int i = 0; i < intArray.length; i++){
            sum += intArray[i];
        }

        mean = sum / intArray.length;
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        int mid = start + (end - start) / 2; // 0 + (8 - 0) / 2 => 4
        median = intArray[mid];

        System.out.println("Mean is: " + mean);
        System.out.println("Median is: " + median);
        for (int i = 0; i < intArray.length; i++){
            if(intArray[i] > mean){
                numbersAboveAvg.append(intArray[i]).append(", ");
            }
        }
        System.out.println("Numbers above average is: " + numbersAboveAvg);

//       for loop to go through the array
//       Structures:
//        1. Conditionals - if, if else, if else if, nested if, switch
//        2. Loops  - for, while, do while loops
//        3. Jumps/Breaks - break, continue, return

//        if (intArray.length < 10){
//            System.out.println("Hurray! we passed");
//        } else if(intArray.length == 10){
//            System.out.println("Hurray it is equal to 10");
//        } else if(intArray.length > 1 && intArray.length < 10){
//            System.out.println("Hurray it is within range");
//        }
//        else {
//            System.out.println("Hurray! we did not passed");
//        }
//
//        switch (intArray.length){
////            case 10 -> System.out.println("The length is equal to 10");
////            case 9 -> System.out.println("The length is equal to 9");
////            default -> System.out.println("The length is neither 9 or 10");
////        }

        //print the numbers 1 to 10 to the console, numbers divisible by 2 between 2 and 10
//        for(int i = 1; i <= 10; i++){
//            System.out.println(i);
//        }

//        for(int num = 2; num >= 2 && num <= 100; num++){
//            boolean isNotDivisibleBy2 = num % 2 != 0;
//            if(isNotDivisibleBy2){
//                System.out.println(num);
//            }
//        }

        int num = 1;
//        while(num <= 10){
//            System.out.println(num);
//            if(num == 3) continue;
//            num++;
//        }

//        do{
//            System.out.println(num);
//            num++;
//        }while(num == 10);

        int[][] twoDimenArr = new int[3][5];
        twoDimenArr[0][0] = 2;
        twoDimenArr[1][2] = 3;
        twoDimenArr[2][1] = 3;
        System.out.println(Arrays.deepToString(twoDimenArr));
        /*  | 0 1 2 3 4
             __________
        *  0| 2,3,4,5,6
        *  1| 1,2,3,4,6
        *  2| 2,3,4,5,7
        *
        *
        * */
    }
}

























