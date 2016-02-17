package marmar.ganaderia_fxml.test;


import marmar.ganaderia_fxml.hibernate.ConectorBovino;
import marmar.ganaderia_fxml.entidades.Bovino;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manuelmartinez
 */
public class BarChartTest extends Application {


    public BarChartTest() {

    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<Number, String> bc
                = new BarChart<Number, String>(yAxis, xAxis);
        bc.setTitle("Poblacion de Razas");
        xAxis.setLabel("Raza");
//        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Cantidad");

        HashMap<String, Integer> data = chartRaza();
        Set<String> keySet = data.keySet();
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Razas");
        ObservableList sd = series1.getData();
        for (String key : keySet) {
            sd.add(new XYChart.Data<>(data.get(key), key));
        }

        Scene scene = new Scene(bc, 800, 600);

        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method return a hashmap with the key representing the bovine race
     * and value the numer of animals that are that race.
     *
     * @return
     */
    public HashMap<String, Integer> chartRaza() {
        HashMap<String, Integer> map = new HashMap<>();
        ConectorBovino cb = new ConectorBovino();
        ArrayList<Bovino> bovinos = cb.getVivosyNoVendidos();

        String r;
        for (Bovino b : bovinos) {
            r = b.getRaza().getNombre();
            if (map.containsKey(r)) {
                Integer get = map.get(r);
                get = get + 1;
                map.put(r, get);
            } else {
                map.put(r, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
