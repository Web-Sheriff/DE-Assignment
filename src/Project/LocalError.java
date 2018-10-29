package Project;

public class LocalError{

    double[] x;
    double[] error;
    double[] exactSol;
    double[] methodSol;

    public LocalError(double[] x, double[] exactSol, double[] methodSol) {
        this.x = x;
        this.exactSol = exactSol;
        this.methodSol = methodSol;
        error = new double[x.length];
    }

    public void findError() {
        for (int i = 0; i < x.length; i++) {
            error[i] = exactSol[i] - methodSol[i];
        }
    }

    public double maxError() {
        double max = 0;
        for (int i = 0; i <= x.length; i++) {
            max = x[i] > max? x[i] : max;
        }
        return max;
    }
}