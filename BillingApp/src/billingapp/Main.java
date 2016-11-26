/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingapp;

import billingapp.controller.MainController;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author arun
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        
        FXMLLoader loader = new FXMLLoader();
        URL resource = this.getClass().getResource("/billingapp/resource/views/MainView.fxml");
        loader.setLocation(resource);
        Parent root = null;
        try {
            root = loader.<BorderPane>load();
        } catch (IOException e) {
            
            throw e;
        }

        final MainController mainController = loader.getController();
        mainController.MainWindow = stage;
        
        
        
        
        Scene scene = new Scene(root,1024,700);
        
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
