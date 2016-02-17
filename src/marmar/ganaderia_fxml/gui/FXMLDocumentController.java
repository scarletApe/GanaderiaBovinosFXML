/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.gui;

import marmar.ganaderia_fxml.hibernate.ConectorBovino;
import marmar.ganaderia_fxml.hibernate.ConectorRaza;
import marmar.ganaderia_fxml.hibernate.ConectorVacunacion;
import marmar.ganaderia_fxml.hibernate.ConectorVenta;
import marmar.ganaderia_fxml.entidades.Bovino;
import marmar.ganaderia_fxml.entidades.Raza;
import marmar.ganaderia_fxml.entidades.Vacunacion;
import marmar.ganaderia_fxml.entidades.Venta;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.hibernate.collection.internal.PersistentSet;

/**
 *
 * @author manuelmartinez
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Bovino> tablaBov;

    @FXML
    private Button bBovNuevo;

    @FXML
    private Button bBovEliminar;

    @FXML
    private ComboBox<String> comboBovSexo;

    @FXML
    private ComboBox<String> comboBovEdad;

    @FXML
    private Button bRazEliminar;

    @FXML
    private ComboBox<String> comboBovEstado;

    @FXML
    private Button bRazNuevo;

    @FXML
    private ComboBox<Raza> comboBovRaza;

    @FXML
    private TableView<Raza> tablaRazas;

    @FXML
    private ComboBox<String> comboBovAretado;

    @FXML
    private TextField tfBovAnos;

    @FXML
    private Button bBovModificar;

    @FXML
    private Button bRazModificar;

    @FXML
    private Button bRazaActualizar;

    @FXML
    private Button bBovActualizar;

    @FXML
    private Button bVentasEliminar;

    @FXML
    private Button bVentasModificar;

    @FXML
    private Button bVentasActualizar;

    @FXML
    private TableView<Venta> tablaVentas;

    @FXML
    private TableView<Vacunacion> tablaVacunas;

    @FXML
    private Button bVacunaVerBovinos;

    @FXML
    private Button bVacunaModificar;

    @FXML
    private Button bVacunaEliminar;

    @FXML
    private Button bVacunaActualizar;

    @FXML
    private Button bVentaVerBovinos;

    @FXML
    private TextField tfRegNacColor;

    @FXML
    private Button bRegNacAnadir;

    @FXML
    private Button bRegMtAnadir;

    @FXML
    private Button bRegMtLimpiar;

    @FXML
    private Button bRegMtRemover;

    @FXML
    private ComboBox<String> cbRegNacSexo;

    @FXML
    private Button bRegRazaLimpiar;

    @FXML
    private Button bRegNacLimpiar2;

    @FXML
    private TextField tfRegRazaNombre;

    @FXML
    private Button bRegRazaGuardar;

    @FXML
    private Button bRegNacLimpiar;

    @FXML
    private Button bRegNacActualizar;

    @FXML
    private Button bRegNacGuardar;

    @FXML
    private ComboBox<Raza> cbRegNacRaza;

    @FXML
    private Button bRegMtGuardar;

    @FXML
    private DatePicker dpRegNacFN;

    @FXML
    private ListView<Bovino> listRegNac;

    //**************************************************************************
    @FXML
    private TextArea taRegTazaDescri;

    @FXML
    private ListView<Bovino> listRegMtDisp;

    @FXML
    private ListView<Bovino> listRegMtRight;

    @FXML
    private DatePicker dpRegMtFecha;

    @FXML
    private TextField tfRegVenMonto;

    @FXML
    private TextField tfRegVenComprador;

    @FXML
    private DatePicker dpRegVenFecha;

    @FXML
    private ListView<Bovino> listRegVenDisp;

    @FXML
    private ListView<Bovino> listRegVenRight;

    @FXML
    private Tab tabRegBovComp;

    @FXML
    private TabPane tabPaneRegistrar;

    @FXML
    private Tab tabRegistrar;

    @FXML
    private TabPane tabPaneMain;

    @FXML
    private Tab tabRegRaza;

    @FXML
    private TextField tfRegVacuna;

    @FXML
    private TextField tfRegVacunaVeterinario;

    @FXML
    private TextField tfRegVacunaComentario;

    @FXML
    private DatePicker dpRegVacunaFecha;

    @FXML
    private ListView<Bovino> listRegVacunaDisp;

    @FXML
    private ListView<Bovino> listRegVacunaRight;

    @FXML
    private Button bRegVacunaGuardar;

    @FXML
    private Tab tabRegVacuna;

    @FXML
    private TextArea taRegNacComentario;

    @FXML
    private BorderPane paneGrafo;

    @FXML
    private ComboBox<String> cbGrafos;

    //**************************************************************************
    @FXML
    private TextField tfRB_ID;

    @FXML
    private TextField tfRB_Arete;

    @FXML
    private TextField tfRB_Apodo;

    @FXML
    private TextField tfRB_Color;

    @FXML
    private ComboBox<String> cbRB_Sexo;

    @FXML
    private ComboBox<Raza> cbRB_Raza;

    @FXML
    private ComboBox<String> cbRB_Melona;

    @FXML
    private DatePicker dpRB_FNac;

    @FXML
    private DatePicker dpRB_FMue;

    @FXML
    private TextArea taRB_Com;

    @FXML
    private Button bRB_Guardar;

    @FXML
    private ComboBox<String> cbReporte;

    @FXML
    private WebView viewReporte;

    @FXML
    private Tab tabReportes;

    private ConectorRaza conraza;
    private ConectorBovino conbovino;
    private ConectorVenta conventa;
    private ConectorVacunacion convacuna;

    private Raza selectedRaza;
    private Bovino selectedBovino;
    private ChartManager charter;
    private ReportManager reporter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        conraza = new ConectorRaza();
        conbovino = new ConectorBovino();
        conventa = new ConectorVenta();
        convacuna = new ConectorVacunacion();

        charter = new ChartManager();
        reporter = new ReportManager();

        fillBovineTab();
        fillRazaTab();
        fillVentaTab();
        fillVacunacionTab();

        fillRegBovinoTab();
        fillRegVenTab();
        fillRegVacunaTab();
        fillRegNacTab();
        fillRegMtTab();

        fillGrafoTab();
        fillReporteTab();

        //para que muestre el pie chart desde un principio
        switchChart('1');
        switchReport('1');
    }

    //**************************************************************************
    //******  Los metodos para bovinos tab
    //**************************************************************************
    @FXML
    private void handleButtonBovNuevo(ActionEvent e) {

    }

    @FXML
    private void handleButtonBovModificar(ActionEvent e) {

        Bovino selectedItem = tablaBov.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            tabPaneMain.getSelectionModel().select(tabRegistrar);
            tabPaneRegistrar.getSelectionModel().select(tabRegBovComp);

            bRB_Guardar.setText("Actualizar Bovino");
            selectedBovino = selectedItem;

            tfRB_ID.setText(selectedItem.getId_bovino() + "");
            tfRB_Arete.setText(selectedItem.getNum_arete());
            tfRB_Apodo.setText(selectedItem.getApodo());
            tfRB_Color.setText(selectedItem.getPelaje());
            taRB_Com.setText(selectedItem.getComentario());

            java.sql.Date d = (java.sql.Date) selectedItem.getFecha_nacimiento();
            if (d != null) {
                dpRB_FNac.setValue(d.toLocalDate());
            }

            d = (java.sql.Date) selectedItem.getFecha_muerte();
            if (d != null) {
                dpRB_FMue.setValue(d.toLocalDate());
            }

            cbRB_Melona.setValue(selectedItem.getMelona());
            cbRB_Sexo.setValue(selectedItem.getSexo());
            cbRB_Raza.setValue(selectedItem.getRaza());
        }
    }

    @FXML
    private void handleButtonBovEliminar(ActionEvent e) {
        Bovino selectedItem = tablaBov.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            conbovino.delete(selectedItem);
            actualizarBovineTab();
        }
    }

    @FXML
    private void handleButtonBovActualizar(ActionEvent e) {
        actualizarBovineTab();
    }

    @FXML
    private void handleButtonBovVerReporte(ActionEvent e) {
        Bovino selectedItem = tablaBov.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tabPaneMain.getSelectionModel().select(tabReportes);

            final WebEngine webEngine = viewReporte.getEngine();
            webEngine.loadContent(reporter.getReporteBovino(selectedItem));
        }
    }
    //**************************************************************************
    //******  Los metodos para raza tab
    //**************************************************************************

    @FXML
    private void handleButtonRazNuevo(ActionEvent e) {

    }

    @FXML
    private void handleButtonRazModificar(ActionEvent e) {
        Raza selectedItem = tablaRazas.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            tabPaneMain.getSelectionModel().select(tabRegistrar);
            tabPaneRegistrar.getSelectionModel().select(tabRegRaza);

            bRegRazaGuardar.setText("Actualizar Raza");

            selectedRaza = selectedItem;
            tfRegRazaNombre.setText(selectedItem.getNombre());
            taRegTazaDescri.setText(selectedItem.getDescripcion());
        }
    }

    @FXML
    private void handleButtonRazEliminar(ActionEvent e) {
        Raza selectedItem = tablaRazas.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            conraza.delete(selectedItem);
            actualizarRazaTab();
        }
    }

    @FXML
    private void handleButtonRazActualizar(ActionEvent e) {
        actualizarRazaTab();
    }

    //**************************************************************************
    //******  Los metodos para ventas tab
    //**************************************************************************
    @FXML
    private void handleButtonVentaVerBovinos(ActionEvent e) {
        Venta selectedItem = tablaVentas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tabPaneMain.getSelectionModel().select(tabReportes);

            final WebEngine webEngine = viewReporte.getEngine();
            webEngine.loadContent(reporter.getReportVenta(selectedItem));
        }
    }

    @FXML
    private void handleButtonVentaModificar(ActionEvent e) {

    }

    @FXML
    private void handleButtonVentaEliminar(ActionEvent e) {
        Venta selectedItem = tablaVentas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            conventa.delete(selectedItem);
            actualizarVentaTab();
        }
    }

    @FXML
    private void handleButtonVentaActualizar(ActionEvent e) {
        actualizarVentaTab();
    }

    //**************************************************************************
    //******  Los metodos para vacunas tab
    //**************************************************************************
    @FXML
    private void handleButtonVacunaVerBovinos(ActionEvent e) {
        Vacunacion selectedItem = tablaVacunas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tabPaneMain.getSelectionModel().select(tabReportes);

            final WebEngine webEngine = viewReporte.getEngine();
            webEngine.loadContent(reporter.getReportVacunacion(selectedItem));
        }
    }

    @FXML
    private void handleButtonVacunaModificar(ActionEvent e) {

    }

    @FXML
    private void handleButtonVacunaEliminar(ActionEvent e) {
        Vacunacion selectedItem = tablaVacunas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            convacuna.delete(selectedItem);
            actualizarVacunacionTab();
        }
    }

    @FXML
    private void handleButtonVacunaActualizar(ActionEvent e) {
        actualizarVacunacionTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar nacimeintos tab
    //**************************************************************************
    @FXML
    private void handleButtonRegNacActualizar(ActionEvent e) {
        //llenar el combobox de razas
        ObservableList<Raza> razaData = FXCollections.observableArrayList();
        ArrayList<Raza> alraza = conraza.getAll();
        alraza.stream().forEach((alraza1) -> {
            razaData.add(alraza1);
        });
        cbRegNacRaza.setItems(razaData);
    }

    @FXML
    private void handleButtonRegNacLimpiar(ActionEvent e) {
        tfRegNacColor.clear();
//        dpRegNacFN

    }

    @FXML
    private void handleButtonRegNacAnadir(ActionEvent e) {
        String color = tfRegNacColor.getText();
        String sexo = cbRegNacSexo.getSelectionModel().getSelectedItem();
        Raza raza = cbRegNacRaza.getSelectionModel().getSelectedItem();
        String da = dpRegNacFN.getEditor().getText();
//        String comentario = ta

        System.out.println("date string=" + da);

        if (color != null
                && sexo != null
                && raza != null
                && da != null
                && !da.isEmpty()
                && !color.isEmpty()) {
            Date fn = new Date(da);
            Bovino b = new Bovino(sexo, color, fn, raza);
            listRegNac.getItems().add(b);

            handleButtonRegNacLimpiar(e);
        }
    }

    @FXML
    private void handleButtonRegNacLimpiar2(ActionEvent e) {
        listRegNac.getItems().clear();
    }

    @FXML
    private void handleButtonRegNacGuardar(ActionEvent e) {
        ObservableList<Bovino> items = listRegNac.getItems();
        items.stream().forEach((item) -> {
            conbovino.saveNew(item);
        });
        handleButtonRegNacLimpiar2(e);
        actualizarBovineTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar razas tab
    //**************************************************************************
    @FXML
    private void handleButtonRegRazaLimpiar(ActionEvent e) {
        tfRegRazaNombre.clear();
        taRegTazaDescri.clear();
        bRegRazaGuardar.setText("Guardar");
    }

    @FXML
    private void handleButtonRegRazaGuardar(ActionEvent e) {
        String nombre = tfRegRazaNombre.getText();
        String descri = taRegTazaDescri.getText();

        if (nombre != null & descri != null
                & !nombre.isEmpty() && !descri.isEmpty()) {

            if (bRegRazaGuardar.getText().equalsIgnoreCase("Actualizar Raza")) {
                selectedRaza.setNombre(nombre);
                selectedRaza.setDescripcion(descri);
                conraza.update(selectedRaza);
                handleButtonRegRazaLimpiar(e);
                bRegRazaGuardar.setText("Guardar");

            } else {
                Raza r = new Raza(nombre, descri);
                conraza.saveNew(r);
                handleButtonRegRazaLimpiar(e);
            }
        }
        actualizarRazaTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar muertes tab
    //**************************************************************************
    @FXML
    private void handleButtonRegMTAnadir(ActionEvent e) {
        Bovino selectedItem = listRegMtDisp.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegMtDisp.getItems().remove(selectedItem);
            listRegMtRight.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegMTRemover(ActionEvent e) {
        Bovino selectedItem = listRegMtRight.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegMtRight.getItems().remove(selectedItem);
            listRegMtDisp.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegMTLimpiar(ActionEvent e) {
        fillRegMtTab();
        dpRegMtFecha.getEditor().setText("");
    }

    @FXML
    private void handleButtonRegMTGuardar(ActionEvent e) {
        String f = dpRegMtFecha.getEditor().getText();
        if (f != null && !f.isEmpty()) {
            Date fecha = new Date(f);
            Bovino b;
            ObservableList<Bovino> items = listRegMtRight.getItems();
            for (Bovino item : items) {
                b = item;
                b.setFecha_muerte(fecha);
                conbovino.update(b);
            }

            fillRegMtTab();
        }
        actualizarBovineTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar ventas tab
    //**************************************************************************
    @FXML
    private void handleButtonRegVenAnadir(ActionEvent e) {
        Bovino selectedItem = listRegVenDisp.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegVenDisp.getItems().remove(selectedItem);
            listRegVenRight.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegVenRemover(ActionEvent e) {
        Bovino selectedItem = listRegVenRight.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegVenRight.getItems().remove(selectedItem);
            listRegVenDisp.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegVenLimpiar(ActionEvent e) {
        fillRegVenTab();
    }

    @FXML
    private void handleButtonRegVenGuardar(ActionEvent e) {
        //TODO
        String f = dpRegVenFecha.getEditor().getText();
        String monto = tfRegVenMonto.getText();
        String comprador = tfRegVenComprador.getText();

        if (f != null && !f.isEmpty()
                && monto != null && !monto.isEmpty()
                && comprador != null && !comprador.isEmpty()) {

            Date fecha = new Date(f);
            Venta v = new Venta(comprador, fecha, new BigDecimal(monto));
            conventa.saveNew(v);
            Bovino b;

            ObservableList<Bovino> items = listRegVenRight.getItems();
            for (Bovino item : items) {
                b = item;
                b.setVenta(v);
                conbovino.update(b);
            }

            fillRegVenTab();
        }
        actualizarVentaTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar vacunacion tab
    //**************************************************************************
    @FXML
    private void handleButtonRegVacunaAnadir(ActionEvent e) {
        Bovino selectedItem = listRegVacunaDisp.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegVacunaDisp.getItems().remove(selectedItem);
            listRegVacunaRight.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegVacunaRemover(ActionEvent e) {
        Bovino selectedItem = listRegVacunaRight.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listRegVacunaRight.getItems().remove(selectedItem);
            listRegVacunaDisp.getItems().add(selectedItem);
        }
    }

    @FXML
    private void handleButtonRegVacunaLimpiar(ActionEvent e) {
        fillRegVacunaTab();
    }

    @FXML
    private void handleButtonRegVacunaGuardar(ActionEvent e) {
        //TODO
        String f = dpRegVacunaFecha.getEditor().getText();
        String vacuna = tfRegVacuna.getText();
        String veterinario = tfRegVacunaVeterinario.getText();
        String comentario = tfRegVacunaComentario.getText();

        if (f != null && !f.isEmpty()
                && vacuna != null && !vacuna.isEmpty()
                && veterinario != null && !veterinario.isEmpty()
                && comentario != null && !comentario.isEmpty()) {

            Date fecha = new Date(f);

            Vacunacion vac = new Vacunacion(vacuna, veterinario, comentario, fecha);
//            convacuna.saveNew(vac);
            Bovino b;
            PersistentSet hs;

            ObservableList<Bovino> items = listRegVacunaRight.getItems();
            for (Bovino item : items) {
                b = item;
                hs = (PersistentSet) b.getVacunas();
                hs.add(vac);
                conbovino.update(b);
            }

            fillRegVacunaTab();
            System.out.println("Finished with the vacunas");
        }
        actualizarVacunacionTab();
    }

    //**************************************************************************
    //******  Los metodos para registrar bovino tab
    //**************************************************************************
    @FXML
    private void handleButtonRegBovinoLimpiar(ActionEvent e) {
        fillRegBovinoTab();
        bRB_Guardar.setText("Guardar");
    }

    @FXML
    private void handleButtonRegBovinoGuardar(ActionEvent e) {
        //TODO
        String arete = tfRB_Arete.getText();
        String apodo = tfRB_Apodo.getText();
        String color = tfRB_Color.getText();
        String sexo = cbRB_Sexo.getSelectionModel().getSelectedItem();
        Raza raza = cbRB_Raza.getSelectionModel().getSelectedItem();
        String melona = cbRB_Melona.getSelectionModel().getSelectedItem();
        String fn = dpRB_FNac.getEditor().getText();
        String fm = dpRB_FMue.getEditor().getText();
        String comentario = taRB_Com.getText();

        if (fn.isEmpty()) {
            return;
        }

        Date nacimeinto = new Date(fn);

        if (bRB_Guardar.getText().equalsIgnoreCase("Actualizar Bovino")) {
            Bovino b = selectedBovino;
            b.setSexo(sexo);
            b.setPelaje(color);
            b.setFecha_nacimiento(nacimeinto);
            b.setNum_arete(arete);
            b.setApodo(apodo);
            b.setMelona(melona);
            b.setRaza(raza);
            b.setComentario(comentario);

            if (!fm.isEmpty()) {
                Date muerte = new Date(fm);
                b.setFecha_muerte(muerte);
            } else {
                b.setFecha_muerte(null);
            }

            conbovino.update(b);
            handleButtonRegBovinoLimpiar(e);
        } else {

            Bovino b = new Bovino(sexo, color, nacimeinto, raza);
            b.setNum_arete(arete);
            b.setApodo(apodo);
            b.setMelona(melona);
            b.setComentario(comentario);

            if (!fm.isEmpty()) {
                Date muerte = new Date(fm);
                b.setFecha_muerte(muerte);
            } else {
                b.setFecha_muerte(null);
            }

            conbovino.saveNew(b);
            handleButtonRegBovinoLimpiar(e);
        }
        actualizarBovineTab();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //     los metodos para llenar y actualizar los tabs
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void fillRazaTab() {
        ObservableList<Raza> razaData = FXCollections.observableArrayList();
        ArrayList<Raza> alraza = conraza.getAll();
        alraza.stream().forEach((alraza1) -> {
            razaData.add(alraza1);
        });

        TableColumn colID = new TableColumn("Id");
        colID.setMinWidth(100);
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_raza"));

        TableColumn colNombre = new TableColumn("Nombre");
        colNombre.setMinWidth(200);
        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        TableColumn colDescripcion = new TableColumn("Descripcion");
        colDescripcion.setMinWidth(500);
        colDescripcion.setCellValueFactory(
                new PropertyValueFactory<>("descripcion"));

        tablaRazas.setItems(razaData);
        tablaRazas.getColumns().clear();
        tablaRazas.getColumns().addAll(colID, colNombre, colDescripcion);

    }

    private void actualizarRazaTab() {
        ArrayList<Raza> alraza = conraza.getAll();
        tablaRazas.getItems().clear();
        tablaRazas.getItems().addAll(alraza);
    }

    private void fillBovineTab() {
        tfBovAnos.setText("0");

        //llenar el combobox de sexos
        ObservableList<String> sexos
                = FXCollections.observableArrayList(
                        "Ambos",
                        "Hembra",
                        "Macho"
                );
        comboBovSexo.setItems(sexos);
        comboBovSexo.setValue("Ambos");
        comboBovSexo.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> o, String ov, String nv) -> {
                    actualizarBovineTab();
                });

        //llenar el combobox de estados
        ObservableList<String> estados
                = FXCollections.observableArrayList(
                        "Todo Estado",
                        "Vivas",
                        "Muertas",
                        "Vendidas"
                );
        comboBovEstado.setItems(estados);
        comboBovEstado.setValue("Vivas");
        comboBovEstado.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> o, String ov, String nv) -> {
                    actualizarBovineTab();
                });

        //llenar el combobox de aretados
        ObservableList<String> aretados
                = FXCollections.observableArrayList(
                        "Todas",
                        "Con Arete",
                        "Sin Arete"
                );
        comboBovAretado.setItems(aretados);
        comboBovAretado.setValue("Todas");
        comboBovAretado.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> o, String ov, String nv) -> {
                    actualizarBovineTab();
                });

        //llenar el combobox de edades
        ObservableList<String> edades
                = FXCollections.observableArrayList(
                        "Toda Edad",
                        "Mayor o Igual Que",
                        "Menor o Igual Que"
                );
        comboBovEdad.setItems(edades);
        comboBovEdad.setValue("Toda Edad");
        comboBovEdad.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> o, String ov, String nv) -> {
                    actualizarBovineTab();
                });

        //llenar el combobox de razas
//        ObservableList<Raza> razaData = FXCollections.observableArrayList();
//        ArrayList<Raza> alraza = conraza.getAll();
//        alraza.stream().forEach((alraza1) -> {
//            razaData.add(alraza1);
//        });
//        comboBovRaza.setItems(razaData);
        //llenar la tabla de bovinos
        ObservableList<Bovino> bovinoData = FXCollections.observableArrayList();
        ArrayList<Bovino> bovinos = conbovino.getVivosyNoVendidos();
        bovinos.stream().forEach((bovino) -> {
            bovinoData.add(bovino);
        });

        TableColumn colID = new TableColumn("Id");
        colID.setMinWidth(50);
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_bovino"));

        TableColumn colArete = new TableColumn("Arete");
        colArete.setMinWidth(100);
        colArete.setCellValueFactory(
                new PropertyValueFactory<>("num_arete"));

        TableColumn colSexo = new TableColumn("Sexo");
        colSexo.setMinWidth(100);
        colSexo.setCellValueFactory(
                new PropertyValueFactory<>("sexo"));

        TableColumn colColor = new TableColumn("Color");
        colColor.setMinWidth(100);
        colColor.setCellValueFactory(
                new PropertyValueFactory<>("pelaje"));

        TableColumn colMelona = new TableColumn("Melona");
        colMelona.setMinWidth(50);
        colMelona.setCellValueFactory(
                new PropertyValueFactory<>("melona"));

        TableColumn colApodo = new TableColumn("Apodo");
        colApodo.setMinWidth(100);
        colApodo.setCellValueFactory(
                new PropertyValueFactory<>("apodo"));

        TableColumn colFNaci = new TableColumn("Fecha Naci.");
        colFNaci.setMinWidth(100);
        colFNaci.setCellValueFactory(
                new PropertyValueFactory<>("fecha_nacimiento"));

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        TableColumn colEdad = new TableColumn("Edad (Meses)");
        colEdad.setMinWidth(100);
        colEdad.setCellValueFactory(
                new PropertyValueFactory<>("edad"));
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        TableColumn colFMuer = new TableColumn("Fecha Muerte");
        colFMuer.setMinWidth(100);
        colFMuer.setCellValueFactory(
                new PropertyValueFactory<>("fecha_muerte"));

        TableColumn colRaza = new TableColumn("Raza");
        colRaza.setMinWidth(100);
        colRaza.setCellValueFactory(
                new PropertyValueFactory<>("raza"));

        TableColumn colVenta = new TableColumn("Venta");
        colVenta.setMinWidth(300);
        colVenta.setCellValueFactory(
                new PropertyValueFactory<>("venta"));

        TableColumn colComentario = new TableColumn("Comentario");
        colComentario.setMinWidth(300);
        colComentario.setCellValueFactory(
                new PropertyValueFactory<>("comentario"));

//        tablaBov.getItems().clear();
        tablaBov.getColumns().clear();

        tablaBov.setItems(bovinoData);
        tablaBov.getColumns().addAll(
                colID,
                colArete,
                colSexo,
                colColor,
                colRaza,
                colApodo,
                colMelona,
                colFNaci,
                colEdad,
                colFMuer,
                colVenta,
                colComentario);
    }

    private void actualizarBovineTab() {
        //llenar el combobox de razas
//        ArrayList<Raza> alraza = conraza.getAll();
//        comboBovRaza.getItems().clear();
//        comboBovRaza.getItems().addAll(alraza);

        //llenar la tabla de bovinos
//        ArrayList<Bovino> bovinos = conbovino.getAll();
//        tablaBov.getItems().clear();
//        tablaBov.getItems().addAll(bovinos);
        String sexo = comboBovSexo.getSelectionModel().getSelectedItem();
        String estado = comboBovEstado.getSelectionModel().getSelectedItem();
        String arete = comboBovAretado.getSelectionModel().getSelectedItem();
        String edad = comboBovEdad.getSelectionModel().getSelectedItem();
        int meses = 0;
        try {
            meses = Integer.parseInt(tfBovAnos.getText());
        } catch (Exception e) {
            System.out.println("es no es un entero!!! >:(");
        }

        ArrayList<Bovino> bovinos = conbovino.getBovinosFiltrados(sexo, estado, arete, selectedRaza, edad, meses);
        tablaBov.getItems().clear();
        tablaBov.getItems().addAll(bovinos);
    }

    private void fillVentaTab() {
        ObservableList<Venta> ventaData = FXCollections.observableArrayList();
        ArrayList<Venta> ventas = conventa.getAll();
        ventas.stream().forEach((venta) -> {
            ventaData.add(venta);
        });

        TableColumn colID = new TableColumn("Id");
        colID.setMinWidth(100);
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_venta"));

        TableColumn colComprador = new TableColumn("Comprador");
        colComprador.setMinWidth(200);
        colComprador.setCellValueFactory(
                new PropertyValueFactory<>("comprador"));

        TableColumn colMonto = new TableColumn("Monto");
        colMonto.setMinWidth(100);
        colMonto.setCellValueFactory(
                new PropertyValueFactory<>("monto"));

        TableColumn colFechaVenta = new TableColumn("Fecha de Venta");
        colFechaVenta.setMinWidth(200);
        colFechaVenta.setCellValueFactory(
                new PropertyValueFactory<>("fecha_venta"));

        tablaVentas.setItems(ventaData);
        tablaVentas.getColumns().clear();
        tablaVentas.getColumns().addAll(colID,
                colComprador,
                colMonto,
                colFechaVenta);
    }

    private void actualizarVentaTab() {
        ArrayList<Venta> ventas = conventa.getAll();
        tablaVentas.getItems().clear();
        tablaVentas.getItems().addAll(ventas);
    }

    private void fillVacunacionTab() {
        ObservableList<Vacunacion> vacunaData = FXCollections.observableArrayList();
        ArrayList<Vacunacion> vacunaciones = convacuna.getAll();
        vacunaciones.stream().forEach((vacunacione) -> {
            vacunaData.add(vacunacione);
        });

        TableColumn colID = new TableColumn("Id");
        colID.setMinWidth(50);
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_vacunacion"));

        TableColumn colMedico = new TableColumn("Veterinario");
        colMedico.setMinWidth(200);
        colMedico.setCellValueFactory(
                new PropertyValueFactory<>("medico"));

        TableColumn colTipo = new TableColumn("Vacuna");
        colTipo.setMinWidth(100);
        colTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));

        TableColumn colFormula = new TableColumn("Comentario");
        colFormula.setMinWidth(300);
        colFormula.setCellValueFactory(
                new PropertyValueFactory<>("formula"));

        TableColumn colFechaVacuna = new TableColumn("Fecha de Vacunación");
        colFechaVacuna.setMinWidth(200);
        colFechaVacuna.setCellValueFactory(
                new PropertyValueFactory<>("fecha_vacunacion"));

        tablaVacunas.setItems(vacunaData);
        tablaVacunas.getColumns().clear();
        tablaVacunas.getColumns().addAll(colID,
                colMedico,
                colTipo,
                colFormula,
                colFechaVacuna);
    }

    private void actualizarVacunacionTab() {
        ArrayList<Vacunacion> vacunaciones = convacuna.getAll();
        tablaVacunas.getItems().clear();
        tablaVacunas.getItems().addAll(vacunaciones);
    }

    private void fillRegNacTab() {
        //llenar el combobox de sexos
        ObservableList<String> sexos
                = FXCollections.observableArrayList(
                        "Hembra",
                        "Macho"
                );
        cbRegNacSexo.setItems(sexos);
        cbRegNacSexo.setValue("Hembra");

        //llenar el combobox de razas
        ObservableList<Raza> razaData = FXCollections.observableArrayList();
        ArrayList<Raza> alraza = conraza.getAll();
        alraza.stream().forEach((alraza1) -> {
            razaData.add(alraza1);
        });
        cbRegNacRaza.setItems(razaData);
        cbRegNacRaza.setValue(alraza.get(0));

        ObservableList<Bovino> nacimientosData = FXCollections.observableArrayList();
        listRegNac.setItems(nacimientosData);
    }

    private void fillRegMtTab() {
        //llenar la lista de los bovinos disponibles
        ObservableList<Bovino> bovData = FXCollections.observableArrayList();
        ArrayList<Bovino> bovinos = conbovino.getVivosyNoVendidos();
        bovinos.stream().forEach((bovino) -> {
            bovData.add(bovino);
        });
        listRegMtDisp.setItems(bovData);

        //limpiar la otra lista
        ObservableList<Bovino> bovData2 = FXCollections.observableArrayList();
        listRegMtRight.setItems(bovData2);
    }

    //fillRegVenTab();
    private void fillRegVenTab() {
        tfRegVenComprador.clear();
        tfRegVenMonto.clear();
        dpRegVenFecha.getEditor().clear();

        //llenar la lista de los bovinos disponibles
        ObservableList<Bovino> bovData = FXCollections.observableArrayList();
        ArrayList<Bovino> bovinos = conbovino.getVivosyNoVendidos();
        bovinos.stream().forEach((bovino) -> {
            bovData.add(bovino);
        });
        listRegVenDisp.setItems(bovData);

        //limpiar la otra lista
        ObservableList<Bovino> bovData2 = FXCollections.observableArrayList();
        listRegVenRight.setItems(bovData2);
    }

    //fillRegVacunaTab
    private void fillRegVacunaTab() {
        tfRegVacuna.clear();
        tfRegVacunaVeterinario.clear();
        tfRegVacunaComentario.clear();
        dpRegVacunaFecha.getEditor().clear();

        //llenar la lista de los bovinos disponibles
        ObservableList<Bovino> bovData = FXCollections.observableArrayList();
        ArrayList<Bovino> bovinos = conbovino.getVivosyNoVendidos();
        bovinos.stream().forEach((bovino) -> {
            bovData.add(bovino);
        });
        listRegVacunaDisp.setItems(bovData);

        //limpiar la otra lista
        ObservableList<Bovino> bovData2 = FXCollections.observableArrayList();
        listRegVacunaRight.setItems(bovData2);
    }

    //fillRegBovinoTab
    private void fillRegBovinoTab() {
        tfRB_ID.setText("");
        tfRB_Arete.setText("");
        tfRB_Apodo.setText("");
        tfRB_Color.setText("");
        dpRB_FNac.getEditor().setText("");
        dpRB_FMue.getEditor().setText("");
        taRB_Com.setText("");

        //llenar el combobox de melonas
        ObservableList<String> mel
                = FXCollections.observableArrayList(
                        "Si",
                        "No"
                );
        cbRB_Melona.setItems(mel);
        cbRB_Melona.setValue("No");

        //llenar el combobox de sexos
        ObservableList<String> sexos
                = FXCollections.observableArrayList(
                        "Hembra",
                        "Macho"
                );
        cbRB_Sexo.setItems(sexos);
        cbRB_Sexo.setValue("Hembra");

        //llenar el combobox de razas
        ObservableList<Raza> razaData = FXCollections.observableArrayList();
        ArrayList<Raza> alraza = conraza.getAll();
        alraza.stream().forEach((alraza1) -> {
            razaData.add(alraza1);
        });
        cbRB_Raza.setItems(razaData);
        cbRB_Raza.setValue(alraza.get(0));
    }

    //fill chart tab
    private void fillGrafoTab() {
        //llenar el combobox de grafos
        ObservableList<String> cd = FXCollections.observableArrayList();
        cd.add("1. Población de Bovinos en Grafo Circular");
        cd.add("2. Población de Bovinos en Grafo de Barras");
        cd.add("3. Población de Razas en Grafo de Barras");
        cd.add("4. Nacimeintos por Año en Grafo Lineal");
        cd.add("5. Muertes por Año en Grafo Lineal");

        cbGrafos.setItems(cd);
        cbGrafos.setValue(cd.get(0));

        cbGrafos.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            char c = newValue.charAt(0);
            switchChart(c);
        });
    }

    private void switchChart(char c) {
        switch (c) {
            case '1':
                //1. Grafo Circular de Población de Bovinos
                paneGrafo.setCenter(charter.fillChartPiePopBovinos());
                break;
            case '2':
                //2. Grafo de Barras de Población de Bovinos
                paneGrafo.setCenter(charter.fillChartBarPopBovinos());
                break;
            case '3':
                //3. Población de Razas en Grafo de Barras
                paneGrafo.setCenter(charter.fillChartRazas());
                break;
            case '4':
                //4. Nacimeintos por Año en Grafo Lineal
                paneGrafo.setCenter(charter.fillChartNacimientos());
                break;
            default:
            case '5':
                //5. Muertes por Año en Grafo Lineal
                paneGrafo.setCenter(charter.fillChartMuertes());
                break;
        }
    }

    private void fillReporteTab() {
        //llenar el combobox de grafos
        ObservableList<String> cd = FXCollections.observableArrayList();
        cd.add("1. Reporte General");
        cd.add("2. Reporte de Población de Bovinos Vivos");
        cd.add("3. Reporte de Ventas del Año");
        cd.add("4. Reporte de Vacunaciones del Año");
        cd.add("5. Reporte de Muertes del Año");

        cbReporte.setItems(cd);
        cbReporte.setValue(cd.get(0));

        cbReporte.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> o, String ov, String nv) -> {
            char c = nv.charAt(0);
            switchReport(c);
        });
    }

    private void switchReport(char c) {
        switch (c) {
            case '1':
            default:
                final WebEngine webEngine = viewReporte.getEngine();
                webEngine.loadContent(reporter.getReporteInicial());
                break;

        }
    }

}
