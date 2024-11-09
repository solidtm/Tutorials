package tutorials;

public class Tutorial11 {
    public static void main(String[] args) {
//        printNums(1, 10);
//        fibonacciIterative(10);
//        System.out.println(fibonacciRecursive(7));
        System.out.println( factRecursive(10));
    }

    private static void printNums(int start, int n){
        //base case
        if(start > n) return;
        System.out.println(start);

        //recursive case
        printNums(start + 1, n);
    }

    private static void fibonacciIterative(int n){
        int start1 = 0, start2 = 1;
        System.out.println(start1);
        System.out.println(start2);

        for(int i = 0; i < n-2; i++){
            int sum = start1 + start2;
            System.out.println(sum);
            start1 = start2;
            start2 = sum;
        }
    }

    private static int fibonacciRecursive(int n){
        //base case
        if(n == 0) return 0;
        if(n == 1) return 1;

        //recursive case
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static int factRecursive(int n){
        //base case
        if(n == 0) return 0;
        if(n == 1) return 1;

        //recursive case
        return n + factRecursive(n - 1) ;
    }

/*
     Recursion: Recursion is all about a function calling itself.
     Sometimes elegance is better than readability

     Imagine given the task  to print numbers from 1 to 10;
     In recursion there are two things you check
     1. Base case - This is the condition where the recursion will return
     2. Recursive case - This is the condition where the function will keep calling itself to perform the given task.


     Fibonacci numbers are numbers that start out with 0 and 1
     and then all the other numbers are a sum of the previous 2 numbers.
     First ten fibonacci numbers are: 0,1,1,2,3,5,8,13,21,34

     fib(0) = 0
     fib(1) = 1
     fib(2) = fib(1) + fib(0)  = 1
     fib(3) = fib(2) + fib(1) = 2
     fib(4) = fib(3) + fib(2) = 3
     fib(n) = fib(n-1) + fib(n-2)

     fact(0) = 0
     fact(1) = 1 + fact(0) = 1
     fact(2) = 2 + fact(1) = 3
     fact(3) = 3 + fact(2) = 5
     fact(4) = 4 + fact(3) = 9
     fact(5) = 5 + fact(4) = 14
     fact(n) = n + fact(n - 1)
     5! = 5+4+3+2+1 = 15
     4! = 4+3+2+1
*/
}
