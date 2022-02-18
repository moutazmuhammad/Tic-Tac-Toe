package ticTac;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ticTac.Connection.Session;

/**
 *
 * @author Moutaz
 */
public class MainScreen extends Application {
    
    private Parent root;
    private Scene scene;
    private static Stage stg;
    public static Session session;
    @Override
    public void start(Stage stage) throws Exception {
        
        stg = stage;
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        scene = new Scene(root, 690, 390);
        stage.setScene(scene);
        
        Image icon = new Image("images/icon.png");
	    stage.getIcons().add(icon);
        session = new Session(stg);
        stage.show();
    }
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void changeScene(String mainMenufxml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
