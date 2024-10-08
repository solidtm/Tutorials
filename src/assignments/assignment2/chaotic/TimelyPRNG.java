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
    public int nextInt(int upperBound) {
        return 0;
    }

    @Override
    public int nextInt(int upperBound, int lowerBound) {
        return 0;
    }

    @Override
    public double nextDouble() {
        return 0;
    }
}
