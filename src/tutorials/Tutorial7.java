package tutorials;

public class Tutorial7 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9,10};

        //Constant complexity O(1)
        int value = arr[3] - arr[4];

        //Logarithmic complexity O(log n)
        for(int i = 1; i < arr.length; i *= 2){
            System.out.println(arr[i]);
        }

        //Linear complexity O(n)
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        //Linear Log complexity O(n log n)
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j *= 2){
                System.out.println(arr[j]);
            }

            System.out.println("==================");
        }

        //Quadratic complexity O(n2)
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.println(arr[j]);
            }

            System.out.println("==================");
        }

        //Cubic complexity O(n3)
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.println(arr[j]);
                for(int k = 0; k < arr.length; k++){
                    System.out.println(arr[j]);
                }
            }

            System.out.println("==================");
        }
    }



    /*  Rule of thumb for calculating complexity
      0. Use different alphabets to signify different inputs
    * 1. Remove constants
    * 2. Remove all non-dominant terms


    * 1. Most search algorithms are n log n or log n complexity
      2. Most sort algorithms are log n, n log n, n2


                    2
                  /   \
                 3     4
               /  \   /  \
              1    5  6   7
    * */
}















