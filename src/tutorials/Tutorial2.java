package tutorials;

import java.util.Arrays;

public class Tutorial2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        int c = a < b ? a + b : a - b;

        int[] agesArray = {21, 24, 32, 27, 18, 22, 23};  //agesArray[3]
        Arrays.sort(agesArray);
        System.out.println(Arrays.toString(agesArray));
        int valueIndex = Arrays.binarySearch(agesArray, 32);
        int[] ages;
        ages = new int[4];
        boolean[][] values = new boolean[3][4];


        System.out.println(Arrays.deepToString(values));
//        System.out.println("Age at index 0: " + agesArray[1]);
//        System.out.println(valueIndex);
    }
}

//   System.out.println(c);  this is a single line comment
/**
 *
 * * System.out.println(c);  this is a single line comment
 * */

/*
*
* Ternary operator => ? :     boolean expression ? return true value : return false value
* Comments in Java => Single line comment, multiline comment, doc comment
* Java keywords and expressions
* Arrays in Java
* Array - Collection of data of the same data type stored in a contiguous block of memory.
* contiguous -> side by side or adjacent
* Arrays are zero indexed
* ages -> int
*   0   1   2   3   4   5
* [21, 24, 32, 27, 18, 22, "23"]
*
* 8-bit memory ->
* 21 | 24
*
* Array declaration and assignment
* int[] agesArray;
* Length of an array is the number of element/items in the array
*
* */















