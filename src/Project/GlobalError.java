package Project;

public class GlobalError {

    int n0;
    int N;
    double x0;
    double y0;
    int[] n;
    double X;
    double[] error;

    public GlobalError(int n0, int N, double x0, double y0, double X) {
        this.n0 = n0;
        this.N = N;
        this.x0 = x0;
        this.X = X;
        n = new int[N-n0+1];
        error = new double[N-n0+1];
        for (int i = 0; i < (N-n0+1);i++)
            n[i] = n0+i;
    }

    public void findErrorEuler() {

        for (int i = 0; i < n.length; i++) {
            Euler euler = new Euler(X, x0, y0, n[i]);
            ExactSolution exactSolution = new ExactSolution(X,x0,y0,n[i]);
            LocalError localError = new LocalError(euler.x,exactSolution.y,euler.y);
            error[i] = localError.maxError();
        }
    }

    public void findIError() {

        for (int i = 0; i < n.length; i++) {
            IEuler iEuler = new IEuler(X, x0, y0, n[i]);
            ExactSolution exactSolution = new ExactSolution(X,x0,y0,n[i]);
            LocalError localError = new LocalError(iEuler.x,exactSolution.y,iEuler.y);
            error[i] = localError.maxError();
        }
    }

    public void findRungeKutta() {

        for (int i = 0; i < n.length; i++) {
            RungeKutta rungeKutta = new RungeKutta(X, x0, y0, n[i]);
            ExactSolution exactSolution = new ExactSolution(X,x0,y0,n[i]);
            LocalError localError = new LocalError(rungeKutta.x,exactSolution.y,rungeKutta.y);
            error[i] = localError.maxError();
        }
    }


}
