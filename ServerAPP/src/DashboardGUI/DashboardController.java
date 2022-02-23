/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashboardGUI;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Zaina
 */
public class DashboardController implements Initializable {
    
    @FXML
    private ImageView StartBtn;
    @FXML
    private ImageView StopBtn;
    
    
    @FXML
    public void onStartHover(MouseEvent event){
        StartBtn.setFitWidth(143);
        StartBtn.setFitHeight(115);
    }
    
    @FXML
    public void onStartExit(MouseEvent event){
        StartBtn.setFitWidth(123);
        StartBtn.setFitHeight(125);
    }
    
    @FXML
    public void onStopHover(MouseEvent event){
        StopBtn.setFitWidth(143);
        StopBtn.setFitHeight(115);
    }
    
    @FXML
    public void onStopExit(MouseEvent event){
        StopBtn.setFitWidth(123);
        StopBtn.setFitHeight(125);
    }
    
      @FXML
    public void addPlayer(String name, String Score){
        
    }
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}
