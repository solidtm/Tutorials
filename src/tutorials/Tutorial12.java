package tutorials;

import java.util.Arrays;

public class Tutorial12 {
    public static void main(String[] args) {
        int[] numbers = {34, 7, 65, 2, 8, 1, 2};

        System.out.println(Arrays.toString(bubbleSortIterative(numbers)));
        selectSort(numbers, numbers.length);
        System.out.println(Arrays.toString(numbers));
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    static int[] bubbleSortIterative(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }

        return numbers;
    }

    public static void selectSort(int[] numbers, int n){
        for(int lastUnsortedIndex = n - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            int selectedIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (numbers[i] > numbers[selectedIndex]){
                    selectedIndex = i;
                }
            }

            swapSelect(numbers, selectedIndex, lastUnsortedIndex);
        }
    }

    public static void swapSelect(int[] array, int i, int j){
        if (i == j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

/*
* Sorting: Is about putting things(data) in order
* Various types of sorting algorithms
* 1. Bubble sort
* 2. Selection sort
* 3. Insertion sort
* 4. Merge sort - Is the most time efficient sorting algorithm, but isn't space efficient
* 5. Quick Sort - Is the most time and space efficient sorting algorithm
* 6. Heap Sort (Frequency Sort) - is also time efficient but not space efficient
* 7. Radix sort
* 8. Counting sort
*                  i
* Bubble sort - [0,2,3,1,4,5,6,7,8]    selectedIndex = 0
*                          j
* Selection sort -
*
* */
}
