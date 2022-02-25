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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



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
    TableView tableView;
    
    @FXML
    TableColumn players, status;
    @FXML
    TableColumn score; 
    
    
    @FXML
    public void onStartHover(MouseEvent event){
        StartBtn.setFitWidth(143);
        StartBtn.setFitHeight(115);
        audio("btnHover.mp3");
        
    }
    
    @FXML
    public void onStartExit(MouseEvent event){
        StartBtn.setFitWidth(123);
        StartBtn.setFitHeight(125);
    }
    
    @FXML
    public void startOnPress(MouseEvent event){
        StartBtn.setFitWidth(113);
        StartBtn.setFitHeight(115);
        audio("btnClick.mp3");
    }
    
    @FXML
    public void startOnRelease(MouseEvent event){
        StartBtn.setFitWidth(143);
        StartBtn.setFitHeight(115);
    }
    
    @FXML
    public void onStopHover(MouseEvent event){
        StopBtn.setFitWidth(143);
        StopBtn.setFitHeight(115);
        audio("btnHover.mp3");
    }
    
    @FXML
    public void onStopExit(MouseEvent event){
        StopBtn.setFitWidth(123);
        StopBtn.setFitHeight(125);
    }
    
    @FXML
    public void stopOnPress(MouseEvent event){
        StopBtn.setFitWidth(113);
        StopBtn.setFitHeight(130);
        audio("btnClick.mp3");
    }
    
    @FXML
    public void stopOnRelease(MouseEvent event){
        StopBtn.setFitWidth(143);
        StopBtn.setFitHeight(115);
    }
    

    private void audio(String soundEffect){
        Media sound = new Media(getClass().getResource("/audio/"+soundEffect).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        
    }    
    
}
