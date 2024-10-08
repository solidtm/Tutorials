package assignments.assignment2.chaotic;

public interface PRNG {
    long getSeed(); //return the original seed
    int nextInt();  // returns the next random value with 0 as lower bound and Integer.MAX_VALUE as upper bound
    int nextInt(int upperBound) throws PRNGException; // returns the next random value with 0 as lower bound and upperBound as upper bound
    int nextInt(int lowerBound, int upperBound) throws PRNGException; // returns the next random value with lowerBound as lower bound and upperBound as upper bound
    double nextDouble(); //returns the double value from 0 to 1.0
}
