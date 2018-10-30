package Project;

public class Euler extends Grid{

    double[] y;

    public Euler(double X, double x0, double y0, int n) {
        super(X, x0, y0, n);
        y = new double[n+1];
    }

    public void EulerMethod() {
        for (int i = 0; i <= n; i++) {
            y[i+1] = y[i]+h* RightHandSight.RHS(x[i],y[i]);
        }
     }
}
