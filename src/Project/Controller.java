package Project;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller {

    public NumberAxis x;
    public NumberAxis y;
    public LineChart graph;
    public LineChart graph_l_e;
    public LineChart graph_g_e;
    public Button methods;
    public Button global_errors;
    public TextField X;
    public TextField x0;
    public TextField y0;
    public TextField n;
    public TextField n0;
    public TextField N;

    public void initialize() {

        methods.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            getGraph(Double.parseDouble(x0.getText()), Double.parseDouble(X.getText()),
                    Double.parseDouble(y0.getText()),Integer.parseInt(n.getText()));
        });
    }

    public void getGraph(double x0, double X, double y0, int n) {
        Euler euler = new Euler(X,x0,y0,n);
        IEuler iEuler = new IEuler(X,x0,y0,n);
        RungeKutta rungeKutta = new RungeKutta(X,x0,y0,n);
        ExactSolution exactSolution = new ExactSolution(X,x0,y0,n);

        euler.EulerMethod();
        iEuler.IEulerMethod();
        rungeKutta.RungeKuttaMethod();
        exactSolution.ParticularSolution();

        XYChart.Series eulerGraph = new XYChart.Series();
        XYChart.Series iEulerGraph = new XYChart.Series();
        XYChart.Series rungeKuttaGraph = new XYChart.Series();
        XYChart.Series exactGraph = new XYChart.Series();

        eulerGraph.setName("Euler");
        iEulerGraph.setName("Improved Euler");
        rungeKuttaGraph.setName("Runge-Kutta");
        exactGraph.setName("Exact Solution");

        for (int i = 0; i < euler.x.length; i++) {
            eulerGraph.getData().add(new XYChart.Data<>(euler.x[i],euler.y[i]));
            iEulerGraph.getData().add(new XYChart.Data<>(iEuler.x[i],iEuler.y[i]));
            rungeKuttaGraph.getData().add(new XYChart.Data<>(rungeKutta.x[i],rungeKutta.y[i]));
            exactGraph.getData().add(new XYChart.Data<>(exactSolution.x[i],exactSolution.y[i]));
        }

        graph.getData().add(eulerGraph);
        graph.getData().add(iEulerGraph);
        graph.getData().add(rungeKuttaGraph);
        graph.getData().add(exactGraph);


    }


}
