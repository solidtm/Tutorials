package assignments.assignment2.chaotic;

public class TimelyPRNG implements PRNG{
    private long seed;
    private long state;
    private long lastNanoTime;

    public TimelyPRNG() { this(System.nanoTime()); }

    public TimelyPRNG(long seed) {
        this.seed = seed;
        this.state = seed;
        this.lastNanoTime = System.nanoTime();
    }


    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public int nextInt() {
        long currentNanoTime = System.nanoTime();
        state += (currentNanoTime - lastNanoTime) * seed;
        lastNanoTime = currentNanoTime;
        return (int) (state % Integer.MAX_VALUE);
    }

    @Override
    public int nextInt(int upperBound) throws PRNGException{
        if(upperBound <=0) throw new PRNGException("Upper bound must be positive");
        return nextInt(0, upperBound);
    }

    @Override
    public int nextInt(int upperBound, int lowerBound) throws PRNGException {
        if(upperBound <= lowerBound) throw new PRNGException("Upper bound must be larger than lower bound");
        return (lowerBound + nextInt()) % (upperBound - lowerBound);
    }

    @Override
    public double nextDouble() {

        return nextInt() / (double)Integer.MAX_VALUE;
    }
}
