/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zaina
 */
public class LeaderBoardController implements Initializable {
    
    @FXML
    private ImageView backButton;

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainMenu.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
    }

    private void backOnClick(MouseEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();
            
            Scene fxmlViewScene = new Scene(fxmlViewChild);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);
            
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(LeaderBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    
    @FXML
    private void backOnHover(MouseEvent event){
        backButton.setFitWidth(71);
        backButton.setFitHeight(71);
        backButton.setLayoutX(632);
        backButton.setLayoutY(3);
    }
    
    @FXML
    private void backOnExit(MouseEvent event){
        backButton.setFitWidth(61);
        backButton.setFitHeight(61);
        backButton.setLayoutX(629);
        backButton.setLayoutY(3);               
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
