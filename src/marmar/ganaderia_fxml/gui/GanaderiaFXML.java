/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import com.aquafx_project.AquaFx;
//import org.aerofx.AeroFX;
//import com.guigarage.flatterfx.FlatterFX;

/**
 *
 * @author manuelmartinez
 */
public class GanaderiaFXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/marmar/ganaderia_fxml/gui/FXMLDocument.fxml"));
        
//        AquaFx.style();
//        AeroFX.style();
//        FlatterFX.style();
        
        Scene scene = new Scene(root);
        
        //add chart style
        scene.getStylesheets().add("Chart.css");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
