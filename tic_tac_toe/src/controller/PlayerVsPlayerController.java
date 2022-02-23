package controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Moutaz
 */
public class PlayerVsPlayerController implements Initializable {
    
    @FXML
    private ImageView b0, b1, b2, b3, b4, b5, b6, b7, b8;
    
    @FXML
    private Button backButton, recordButton, screenshotBtn;
    
    @FXML
    private Label xPlayerName, oPlayerName;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private TextField textMessage;
    
    Image X = new Image(getClass().getResourceAsStream("/images/x.png"));
    Image O = new Image(getClass().getResourceAsStream("/images/oO.png"));
    
    private void setXPlayerStep(ImageView b){
        b.setImage(X);
    }
    
    private void setOPlayerStep(ImageView b){
        b.setImage(O);
    }
    
    @FXML
    private void b0ButtonAction(MouseEvent event){
        setXPlayerStep(b0);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b1ButtonAction(MouseEvent event){
        setXPlayerStep(b1);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b2ButtonAction(MouseEvent event) {
        setXPlayerStep(b2);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b3ButtonAction(MouseEvent event){
        setXPlayerStep(b3);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b4ButtonAction(MouseEvent event){
        setXPlayerStep(b4);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b5ButtonAction(MouseEvent event){
        setXPlayerStep(b5);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b6ButtonAction(MouseEvent event) {
        setXPlayerStep(b6);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b7ButtonAction(MouseEvent event){
        setXPlayerStep(b7);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void b8ButtonAction(MouseEvent event){
        setXPlayerStep(b8);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        MainScreen.session.changeScene("/fxml/PlayerInvitationScreen.fxml");
    }
    
    
    @FXML
    private void sendMessageArrow(MouseEvent event){
        
        
    }
    
    @FXML
    private void ScreenShot(MouseEvent event) throws IOException, AWTException {
      
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
      //WritableImage snapshot = stage.getScene().snapshot(null);
     
   
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        File file = fileChooser.showSaveDialog(null); 
        try {
          
            ImageIO.write((BufferedImage) image, "png", new File(file.getAbsolutePath()));
        } catch (IOException ex) {
            System.out.println("Failed to save image!");
        }
        {
            System.out.println("No file choosen!");
        }
    }
    
    private void audio(String soundEffect){
        Media sound = new Media(getClass().getResource("/audio/"+soundEffect).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
