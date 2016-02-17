/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import marmar.ganaderia_fxml.entidades.Bovino;
import marmar.ganaderia_fxml.hibernate.ConectorBovino;

/**
 *
 * @author manuelmartinez
 */
public class ChartManager {

    public LineChart<String, Number> fillChartNacimientos() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mes");
        final LineChart<String, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Nacimientos de Beceros Por Año");

//        lineChart.setCreateSymbols(false);
        lineChart.setAlternativeRowFillVisible(false);

        HashMap<Integer, int[]> data = dataForChartNacimientos();
        Set<Integer> keySet = data.keySet();
        for (Integer key : keySet) {
            int[] get = data.get(key);

            XYChart.Series series = new XYChart.Series();
            series.setName("" + key);
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
        return (lineChart);
    }

    public BarChart<Number, String> fillChartRazas() {

        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<Number, String> chart = new BarChart<>(yAxis, xAxis);
        chart.setTitle("Población de Razas");
        xAxis.setLabel("Raza");
//        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Cantidad");

        HashMap<String, Integer> data = chartRaza();
        Set<String> keySet = data.keySet();
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Razas");
        ObservableList olist = series1.getData();
        for (String key : keySet) {
            olist.add(new XYChart.Data<>(data.get(key), key));
        }
        chart.getData().addAll(series1);
        chart.setLegendVisible(false);
        //set it to pane
        return (chart);
    }

    public PieChart fillChartPiePopBovinos() {

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
            di = (double) data.get(key) / (double) total;
            percent = (int) (di * 100);
            pieChartData.add(new PieChart.Data(key, percent));
        }

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Población de Bovinos");

        //set it to pane
        return (chart);
    }

    public BarChart<Number, String> fillChartBarPopBovinos() {
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<Number, String> chart = new BarChart<>(yAxis, xAxis);
        chart.setTitle("Población de Bovinos");
        xAxis.setLabel("Bovino");
//        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Cantidad");

        HashMap<String, Integer> data = dataForChartEdadesySexo();
        Set<String> keySet = data.keySet();
        XYChart.Series series1 = new XYChart.Series();
        ObservableList olist = series1.getData();
        for (String key : keySet) {
            olist.add(new XYChart.Data<>(data.get(key), key));
        }

        chart.getData().addAll(series1);
        chart.setLegendVisible(false);
        //set it to pane
        return (chart);
    }

    public LineChart<String, Number> fillChartMuertes() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mes");
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Muertes de Bovinos Por Año");

//        lineChart.setCreateSymbols(false);
        lineChart.setAlternativeRowFillVisible(false);

        HashMap<Integer, int[]> data = dataForChartMuertes();
        Set<Integer> keySet = data.keySet();
        for (Integer key : keySet) {
            int[] get = data.get(key);

            XYChart.Series series = new XYChart.Series();
            series.setName("" + key);
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
        return (lineChart);
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
        Calendar cal = Calendar.getInstance();
        for (Bovino bovino : bovinos) {
            cal.setTime(bovino.getFecha_nacimiento());
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH) + 1;
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
        map.put("becerras", crias_f);
        map.put("becerros", crias_m);

        return map;
    }

    /**
     * This method figures out the months between the current date and the date
     * given.
     *
     * @param d The given date.
     * @return Months between the two dates.
     */
    public int getMonthsOld(Date d) {
        Date actual = new Date();

        int actual_months = (actual.getMonth() + 1) + (actual.getYear() * 12);
        int d_months = (d.getMonth() + 1) + (d.getYear() * 12);

        return actual_months - d_months;
    }

    /**
     * This method returns a hashmap where the key is for the year and the array
     * is the months of the year and the number of deaths per month.
     *
     * @return
     */
    public HashMap<Integer, int[]> dataForChartMuertes() {
        HashMap<Integer, int[]> map = new HashMap<>();
        ConectorBovino cb = new ConectorBovino();
        ArrayList<Bovino> bovinos = cb.getAll();

        int year;
        int month;
        Calendar cal = Calendar.getInstance();
        for (Bovino bovino : bovinos) {
            Date fm = bovino.getFecha_muerte();
            if (fm != null) {

                cal.setTime(fm);
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH) + 1;

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
        }

        return map;
    }
}
