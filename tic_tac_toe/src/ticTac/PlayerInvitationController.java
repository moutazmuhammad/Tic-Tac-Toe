package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class PlayerInvitationController implements Initializable {
    @FXML
    private Button BackButton, InvitePlayerButton, AcceptButton;
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException{
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
            
    }
    
    @FXML
    private void inviteButtonAction(ActionEvent event) throws IOException{
       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MultiGameScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
        
    }
    
    @FXML
    private void acceptInvitaionButtonAction(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MultiGameScreen.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    
    
    
}
