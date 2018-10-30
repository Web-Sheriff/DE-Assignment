package Project;

public class RungeKutta extends Grid{

    double[] y;

    public RungeKutta(double X, double x0, double y0, int n) {

        super(X, x0, y0, n);
        y = new double[n+1];
    }

    public  void RungeKuttaMethod() {
        x[0] = x0;
        y[0] = y0;
        for (int i = 1; i <= n; i++) {
            double a = RightHandSight.RHS(x[i-1], y[i-1]);
            double b = RightHandSight.RHS(x[i-1]+h/2,y[i-1]+h/2*a);
            double c = RightHandSight.RHS(x[i-1]+h/2, y[i-1]+h/2*b);
            double d = RightHandSight.RHS(x[i-1]+h/2, y[i-1]+h/2*c);

            y[i] = y[i-1] + h/6*(a+2*b+2*c+d);
        }
    }
}
