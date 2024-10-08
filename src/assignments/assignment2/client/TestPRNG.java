package assignments.assignment2.client;

import assignments.assignment2.chaotic.*;

public class TestPRNG {
    public static void main(String[] args) {
        try{
            PRNG incrementPRNG = new IncrementingPRNG();
            PRNG timelyPRNG = new TimelyPRNG();
            PRNG basicPRNG = new BasicPRNG();

            System.out.println("Testing Incrementing PRNG: ");
            testPRNG(incrementPRNG);

            System.out.println("Testing Timely PRNG: ");
            testPRNG(timelyPRNG);

            System.out.println("Testing Basic PRNG: ");
            testPRNG(basicPRNG);


        } catch (PRNGException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void testPRNG(PRNG prng) throws PRNGException{
        System.out.println("Random integer: " + prng.nextInt());
        System.out.println("Random integer: (0, 100) " + prng.nextInt(100));
        System.out.println("Random integer: (50, 150) " + prng.nextInt(50, 150));
        System.out.println("Random double: " + prng.nextDouble());
    }
}
