package Project;

public class RungeKutta extends Grid{

    double[] y;

    public RungeKutta(double X, double x0, double y0, int n) {

        super(X, x0, y0, n);
        y = new double[n+1];
    }

    public  void RungeKuttaMethod() {
        for (int i = 0; i <= n; i++) {
            double a = RightHandSight.RHS(x[i], y[i]);
            double b = RightHandSight.RHS(x[i]+h/2,y[i]+h/2*a);
            double c = RightHandSight.RHS(x[i]+h/2, y[i]+h/2*b);
            double d = RightHandSight.RHS(x[i]+h/2, y[i]+h/2*c);

            y[i+1] = y[i] + h/6*(a+2*b+2*c+d);
        }
    }
}
