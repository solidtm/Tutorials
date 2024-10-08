package assignments.assignment2.chaotic;

public class BasicPRNG implements PRNG {
    private long seed;
    private long state;

    public BasicPRNG() {
        this(System.currentTimeMillis());
    }

    public BasicPRNG(long seed) {
        this.seed = seed;
        this.state = seed;
    }

    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public int nextInt() {
        state = (1103515245 * state + 12345) %2147483647;
        return (int) state;
    }

    @Override
    public int nextInt(int upperBound) throws PRNGException {
        if(upperBound <=0 ) throw new PRNGException("upperbound must be positive");
        return nextInt (0, upperBound) ;
    }

    @Override
    public int nextInt(int upperBound, int lowerBound) throws PRNGException {
        if(upperBound <= lowerBound) throw new PRNGException("upperbound must be larger than lowerbound");
        return (lowerBound + nextInt()) % (upperBound - lowerBound);
    }

    @Override
    public double nextDouble() {
        return nextInt() / (double)Integer.MAX_VALUE;
    }
}
