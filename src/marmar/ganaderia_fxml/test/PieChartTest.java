package marmar.ganaderia_fxml.test;


import marmar.ganaderia_fxml.hibernate.ConectorBovino;
import marmar.ganaderia_fxml.entidades.Bovino;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
public class PieChartTest extends Application {

    @Override
    public void start(Stage stage) {
//        Scene scene = new Scene(new Group());
        stage.setTitle("Poblacion de Bovinos");
        stage.setWidth(500);
        stage.setHeight(500);

        HashMap<String, Integer> data = dataForChartEdadesySexo();
        int total = 0;
        Set<String> keySet = data.keySet();
        for (String key : keySet) {
            total = total + data.get(key);
        }
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList();

        System.out.println("total=" + total);
        int percent;
        double di;
        for (String key : keySet) {
            di = (double)data.get(key) / (double)total;
            System.out.println("di="+di);
            percent = (int) (di * 100);
            System.out.println(key+"=" + data.get(key));
            System.out.println("percent=" + percent);
            pieChartData.add(new PieChart.Data(key, percent));
            System.out.println("");
        }

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Pobacion de Bovinos");
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

//        ((Group) scene.getRoot()).getChildren().addAll(chart, caption);
//        stage.setScene(scene);
//        //scene.getStylesheets().add("piechartsample/Chart.css");
//        stage.show();
        Scene scene = new Scene(chart, 800, 600);

//        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method returns a hashmap of how many cows, bulls, novillos ...etc
     * there is.
     *
     * @return
     */
    public HashMap<String, Integer> dataForChartEdadesySexo() {
        //Map<String, Integer>
        int vacas = 0;
        int toros = 0;
        int novillos = 0;
        int novillas = 0;
        int crias_f = 0;
        int crias_m = 0;

        ConectorBovino cb = new ConectorBovino();
        ArrayList<Bovino> bovinos = cb.getVivosyNoVendidos();
        String sexo;
        int meses;

        for (Bovino b : bovinos) {
            sexo = b.getSexo();
            if (sexo.equalsIgnoreCase("Hembra")) {
                //es hembra
                meses = getMonthsOld(b.getFecha_nacimiento());
                if (meses >= 24) {
                    vacas++;
                }
                if (meses >= 12 && meses < 24) {
                    novillas++;
                }
                if (meses < 12) {
                    crias_f++;
                }
            } else {
                //es macho
                meses = getMonthsOld(b.getFecha_nacimiento());
                if (meses >= 24) {
                    toros++;
                }
                if (meses >= 12 && meses < 24) {
                    novillos++;
                }
                if (meses < 12) {
                    crias_m++;
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("vacas", vacas);
        map.put("toros", toros);
        map.put("novillas", novillas);
        map.put("novillos", novillos);
        map.put("crias_♂", crias_f);
        map.put("crias_♀", crias_m);

        return map;
    }

    /**
     * This method figures out the months between the current date and the date
     * given.
     *
     * @param d The given date.
     * @return Months between the two dates.
     */
    private int getMonthsOld(Date d) {
        Date actual = new Date();

        int actual_months = (actual.getMonth() + 1) + (actual.getYear() * 12);
        int d_months = (d.getMonth() + 1) + (d.getYear() * 12);

        return actual_months - d_months;
    }
}
