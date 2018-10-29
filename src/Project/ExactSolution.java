package Project;

public class ExactSolution extends IVP {

    double[] y;

    public ExactSolution(double X, double x0, double y0, int n) {
        super(X, x0, y0, n);
    }

    public void ParticularSolution() {
        for (int i = 0; i <= n; i++) {
            y[i] = 2*Math.pow(Math.E,-2*x0)+2*x[i]-1;
        }
    }


}
