/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashboardGUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Zaina
 */
public class DashboardApplication extends Application {
    
    @Override
    public void init(){
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setResizable(false);
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Image icon = new Image("DashboardGUI/icon.png");
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(root, 780, 680);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
