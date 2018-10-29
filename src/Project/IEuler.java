package Project;

public class IEuler extends Grid {

    double[] y;

    public IEuler(double X, double x0, double y0, int n) {
        super(X, x0, y0, n);
        y =  new double[n+1];
    }

    public void EulerMethod() {
        double a;
        double b;

        for (int i = 0; i < n; i++) {
            a = RightHandSight.RHS(x[i],y[0]);
            b = RightHandSight.RHS(x[i+1],y[0]+h*a);
            y[i+1] = y[i]+h/2*(a+b);
        }
    }
}
