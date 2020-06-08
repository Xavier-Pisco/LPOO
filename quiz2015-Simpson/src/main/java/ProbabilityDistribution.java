public class ProbabilityDistribution {
    private double mean;
    private double stddev;

    public ProbabilityDistribution(double mean, double stddev) {
        if (stddev == 0.0) throw new IllegalArgumentException();
        this.mean = mean;
        this.stddev = stddev;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStddev() {
        return stddev;
    }

    public void setStddev(double stddev) {
        this.stddev = stddev;
    }

    public double probabilityDensityFunction(double v) {
        return ((1/(stddev * Math.sqrt(2*Math.PI))) * Math.exp((-0.5) * Math.pow((v - mean)/stddev, 2)));
    }

    /*public double calcRangeProbability(int i, int i1) {
        return probabilityDensityFunction(i) + probabilityDensityFunction(i1);
    }*/
}
