package tutorials;

public class Tutorial1 {
    public static void main(String[] args) {
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        int integerVariable, var2, var3 = 3;

        integerVariable = 23;
        var2 = 2;

        int i = 1234;
//        final int i = 1234;
        System.out.println("Before: " + i);
        long x = 9223372036854775807L;
        float f = 1.234552423423534543534f;
        double d = 1.2345525353453532532523532;
        char c = '%';
//        boolean b = c == '$';
        byte y = 127;
        String s = "My name is Richard, and I am 16 years old";

//        i = 4321;
        System.out.println("After: " + i);
        System.out.println(s);


//        Type casting
        x = i;

        int a = 4, b = 3;
        System.out.println(a % b);


        float gradePoint = 2.34f;
        int integerGradePoint = (int) gradePoint;

        double dValue = gradePoint;

        int val1 = 4, val2 = 2;
        val1 += val2; // => val1 = 4 - 2
        System.out.println(val1);
    }

}

/*
* 1. Introduction to Java - statically typed, OOPL -> server side, client side -> web, mobile etc,
* JVM -> Java virtual machine
* JRE -> Java runtime environment
* JDK -> Java development kit -> methods, classes, objects etc
* IDE -> Integrated development environment
* 2. Data types:
*    Primitive types ->
* Data type       java keyword      memory capacity
* Integer           int             whole numbers btw -2147483648 - 2147483647
* Long              long            whole numbers btw -9223372036854775808 - 9223372036854775807
* Float             float           decimal numbers within 7 decimal places
* Double            double          decimal numbers within 16 decimal places
* Characters        char             single character values defined in single quotes ''
* Valueless         void             represents nothing in java
* Boolean           boolean          represents true or false 0 or 1
* Byte              byte             whole numbers btw -128 - 127
* Short             short            whole numbers btw -32768 - 32767
* String            String           character values defined in double quotes ""
*
* Reference types -> Classes and Objects
*
* 3. Variables and Constants -> Declaring and Initialization of constants and variables
*
* Type casting -> implicit and explicit casting
* Operators ->
* Arithmetic - + , - , / , * , %
* Logical - &&, ||, !
* Relational - >, <, >=, <=
* Bitwise - &, | , ^, ~, >>, <<
* Assignment and Equality - =, -=, +=, /=, *=, %=, ==, ++, --
*
*
*  A  |  B | &  |  |  |  ^ |      ~4 -> 0 1 1 -> 3     4 << 2 -> 1 0 0 0 0
*  1  |  1 | 1  |  1     0                  1
*  1  |  0 | 0  |  1     1
*  0  |  1 | 0  |  1     1
*  0  |  0 | 0  |  0     0
*
*
*
*
* */