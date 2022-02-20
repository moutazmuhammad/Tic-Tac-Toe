package controller;

import ticTac.Connection.Session;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/login.fxml"));
        Parent fxmlViewChild = loader.load();
        LoginController lg = new LoginController();
        session = new Session(stg);
        session.loginController = lg;
        loader.setController(lg);
        
        
        scene = new Scene(fxmlViewChild, 690, 390);
        stage.setScene(scene);
        
        Image icon = new Image("/images/icon.png");
	    stage.getIcons().add(icon);
        
        
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
