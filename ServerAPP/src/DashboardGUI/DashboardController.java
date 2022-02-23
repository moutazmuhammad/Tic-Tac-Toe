/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashboardGUI;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Zaina
 */
public class DashboardController implements Initializable {
    @FXML
    private VBox list;
    @FXML
    private ImageView StartBtn;
    @FXML
    private ImageView StopBtn;
    
    
    @FXML
    public void onStartHover(MouseEvent event){
        StartBtn.setFitWidth(220);
        StartBtn.setFitHeight(160);
    }
    
    @FXML
    public void onStartExit(MouseEvent event){
        StartBtn.setFitWidth(200);
        StartBtn.setFitHeight(150);
    }
    
    @FXML
    public void onStopHover(MouseEvent event){
        StopBtn.setFitWidth(220);
        StopBtn.setFitHeight(160);
    }
    
    @FXML
    public void onStopExit(MouseEvent event){
        StopBtn.setFitWidth(200);
        StopBtn.setFitHeight(150);
    }
    
      @FXML
    public void addPlayer(String name, String Score){
        Label newPlayer = new Label(name+" Score: "+Score);
        newPlayer.setTextFill(Color.BLACK);
        newPlayer.setLineSpacing(2);
        newPlayer.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        list.getChildren().add(newPlayer);
    }
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addPlayer("Nancy", "500");
        addPlayer("BestPlayer", "700");
        
    }    
    
}
