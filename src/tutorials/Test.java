package tutorials;

import java.util.Arrays;

public class Test {
    public int[] removeDuplicates(int[] nums){
        int[] arr = new int[nums.length]; //create an array variable to hold the resulting array without duplicates
        int k = 0;                       // create variable k to fill the new array with non-duplicate values
        Arrays.fill(arr, -1);  // fill the new array with -1 initially

        for (int currVal : nums) { //go through all the values in the nums array
            if (!isSeen(currVal, arr)) { //call the isSeen method to check if we have seen this value before, if we have, it means it is a duplicate
                arr[k] = currVal;   //assign the currVal to index k in the new arr
                k++;                //increment to the next index
            }
        }

        return arr;      //return the array without duplicates
    }

    public boolean isSeen(int value, int[] arr){
        for (int currVal : arr){   //loop through the new array
            if(currVal == value) return true;    //check if the currVal is the value you're looking for and return  true
        }

        return false;   //else if we didn't find the value in arr, return false
    }

    public int arrLength(int[] arr){
        int length = 0; //create variable to hold the length we will calculate
        for(int currVal : arr){ //go through arra values
            if(currVal != -1){ // if the value is not -1
                length++;   //increment length by 1
            }
        }

        return length; //return length
    }

    /*The mean of a set of numbers in a data set is obtained by adding up all the numbers then dividing by the size of the data set. */
    public double getMean(int[] arr){
        int sum = 0;  //first create variable to hold the sum
        for(int currVal : arr){ //go through all the values in the array and sum it up
            if(currVal == -1){ //if the currVal is -1, just stop looping
                break;     //stop looping by breaking out of the loop
            }else{  //if currVal is not -1
                sum += currVal;   //sum up all those values in sum variable => sum = sum + currVal
            }
        }

        return (double) sum / arrLength(arr);  // in the end, calculate the mean
    }

    public double getStdDev(int[] arr){
        double mean = getMean(arr); //step 1: Get the mean and store in a variable mean
        double sumOfSubMeanSquares = 0; // step 2: Create a variable to store the sum of squares of each arr values minus the mean

        for (int currVal : arr){  //go through all the values in the arr
            if(currVal != -1){
                double subtractedMeanVal = currVal - mean; //subtract the mean from each value, store in a variable subtractedMeanVal
                double squaredSubMeanVal = subtractedMeanVal * subtractedMeanVal; // square that subtracted mean value, and store in a variable squaredSubMeanVal
                sumOfSubMeanSquares += squaredSubMeanVal; // add that squared value to the sumOfSubMeanSquares
            }else {
                break;
            }
        }

        double dividedSumOfSubMeanSquares = sumOfSubMeanSquares / arrLength(arr) - 1; // step 3 : Divide the sumOfSubMeanSquares by the array length - 1(ie the number of values in the array)
        return Math.sqrt(dividedSumOfSubMeanSquares); //return the square root of that division
    }
}










