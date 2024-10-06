package tutorials;

import java.util.Scanner;

public class Tutorial4 {

//    User input in Java

    /*
    * Scanner class
    * System + Scanner
    * File System (I/O)
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an integer: ");
        int x = scanner.nextInt();

        System.out.println("The integer you entered is: " + x);
    }
}
