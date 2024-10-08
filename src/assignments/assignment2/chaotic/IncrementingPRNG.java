package assignments.assignment2.chaotic;

public class IncrementingPRNG implements PRNG{
    private long seed;
    private long state;

    public IncrementingPRNG(){
        this(System.currentTimeMillis());
    }

    public IncrementingPRNG(long seed){
        this.seed = seed;
        this.state = seed;
    }

    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public int nextInt() {
        state += seed / 2;
        return (int) (state % Integer.MAX_VALUE);
    }

    @Override
    public int nextInt(int upperBound) throws PRNGException {
        if(upperBound <= 0) throw new PRNGException("Upper bound must be positive");

        return nextInt(0, upperBound);
    }

    @Override
    public int nextInt( int lowerBound,  int upperBound) throws PRNGException {
        if(upperBound <= lowerBound) throw new PRNGException("Upper bound must be larger than lower bound");

        return lowerBound + nextInt() % (upperBound - lowerBound);
    }

    @Override
    public double nextDouble() {
        return nextInt() / (double)Integer.MAX_VALUE;
    }
}
