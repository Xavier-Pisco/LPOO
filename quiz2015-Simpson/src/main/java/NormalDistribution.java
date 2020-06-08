public class NormalDistribution extends ProbabilityDistribution {
    public NormalDistribution(double mean, double stddev) {
        super(mean, stddev);
    }

    public NormalDistribution() {
        super(0.0, 1.0);
    }
}
