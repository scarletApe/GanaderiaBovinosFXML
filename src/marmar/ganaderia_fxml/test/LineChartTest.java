package marmar.ganaderia_fxml.test;


import marmar.ganaderia_fxml.hibernate.ConectorBovino;
import marmar.ganaderia_fxml.entidades.Bovino;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
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
public class LineChartTest extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Nacimientos Por Año");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mes");
        final LineChart<String, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Nacimientos de Beceros Por Año");

//        lineChart.setCreateSymbols(false);
//        lineChart.setAlternativeRowFillVisible(false);

        HashMap<Integer, int[]> data = dataForChartNacimientos();
        Set<Integer> keySet = data.keySet();
        for (Integer key : keySet) {
            int[] get = data.get(key);
            
            XYChart.Series series = new XYChart.Series();
            series.setName(""+key);
            series.getData().add(new XYChart.Data("Ene", get[1]));
            series.getData().add(new XYChart.Data("Feb", get[2]));
            series.getData().add(new XYChart.Data("Mar", get[3]));
            series.getData().add(new XYChart.Data("Abr", get[4]));
            series.getData().add(new XYChart.Data("May", get[5]));
            series.getData().add(new XYChart.Data("Jun", get[6]));
            series.getData().add(new XYChart.Data("Jul", get[7]));
            series.getData().add(new XYChart.Data("Aug", get[8]));
            series.getData().add(new XYChart.Data("Sep", get[9]));
            series.getData().add(new XYChart.Data("Oct", get[10]));
            series.getData().add(new XYChart.Data("Nov", get[11]));
            series.getData().add(new XYChart.Data("Dec", get[12]));
            
            lineChart.getData().add(series);
        }

        Scene scene = new Scene(lineChart);
//        scene.getStylesheets().add("Chart.css");                      
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method returns a hashmap where the key is for the year and the array
     * is the months of the year and the number of calfs born per month.
     *
     * @return
     */
    public HashMap<Integer, int[]> dataForChartNacimientos() {
        HashMap<Integer, int[]> map = new HashMap<>();
        ConectorBovino cb = new ConectorBovino();
        ArrayList<Bovino> bovinos = cb.getAll();

        int year;
        int month;
        for (Bovino bovino : bovinos) {
            Calendar cal =  Calendar.getInstance();
            cal.setTime(bovino.getFecha_nacimiento());

            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH)+1;
//            System.out.println("year="+year+" month="+month);

            if (map.containsKey(year)) {
                int[] get = map.get(year);
                get[month] = get[month] + 1;
                map.put(year, get);
            } else {
                int[] a = new int[13];
                a[month] = 1;
                map.put(year, a);
            }
        }

        return map;
    }
}
