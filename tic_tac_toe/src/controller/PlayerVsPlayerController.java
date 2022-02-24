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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
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
    
    Dialog<ButtonType> dialog;
    
    List<ImageView> myGird;
    List<Image> XOImages;
    List<Integer> myCells,otherPlayerCells;
    private int choice = 0;
    private boolean myTurn=true;

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    
    private void setImage(int cell,int XO){
        myGird.get(cell).setImage(XOImages.get(XO));
    }
    
    @FXML
    private void b0ButtonAction(MouseEvent event){
        addMove(0);
        
    }
    
    @FXML
    private void b1ButtonAction(MouseEvent event){
        addMove(1);
    }
    
    @FXML
    private void b2ButtonAction(MouseEvent event) {
        addMove(2);
    }
    
    @FXML
    private void b3ButtonAction(MouseEvent event){
        addMove(3);
    }
    
    @FXML
    private void b4ButtonAction(MouseEvent event){
        addMove(4);
    }
    
    @FXML
    private void b5ButtonAction(MouseEvent event){
        addMove(5);
    }
    
    @FXML
    private void b6ButtonAction(MouseEvent event) {
        addMove(6);
    }
    
    @FXML
    private void b7ButtonAction(MouseEvent event){
        addMove(7);
    }
    
    @FXML
    private void b8ButtonAction(MouseEvent event){
        addMove(8);
    }
    
    @FXML
    private void BackButtonAction(ActionEvent event)  {
        MainScreen.session.controlManager.setInvitationController(MainScreen.session.changeScene("/fxml/PlayerInvitationScreen.fxml"));
        MainScreen.session.viewOnlinePlayers = true;
        MainScreen.session.getOnlinePlayersRequest();
    }
    
    
    @FXML
    private void sendMessageArrow(MouseEvent event){
        textArea.setText(textArea.getText()+"\nMe : "+textMessage.getText());
        MainScreen.session.sendMessageRequest(MainScreen.session.player.getUsername()+" : "+textMessage.getText());
        textMessage.clear();
    }
    
    public void recieveMessage(String msg){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.setText(textArea.getText()+"\n"+msg);
            }
        });
    }
    
    private void addMove(int cell){
        if(!myTurn || myCells.contains(cell) || otherPlayerCells.contains(cell))
            return;
        myCells.add(cell);
        setImage(cell,choice);
        audio("btnClick.mp3");
        myTurn = false;
        MainScreen.session.addMoveRequest(cell, choice);
        if(checkWin(myCells))
            endGameDialog("Winner", "/fxml/xWinner.fxml");
        else if(myCells.size()+otherPlayerCells.size()==9){
            endGameDialog("Draw", "/fxml/draw.fxml");
        }
    }
    
    public  void setMove(int cell,int choice){
        otherPlayerCells.add(cell);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                setImage(cell,choice);
                audio("btnClick.mp3");
            }
        });
        myTurn = true;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(checkWin(otherPlayerCells))
                    endGameDialog("Game Over", "/fxml/oWinner.fxml");
                else if(myCells.size()+otherPlayerCells.size()==9){
                    endGameDialog("Draw", "/fxml/draw.fxml");
                }
            }
        });
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
    
    
    private void endGameDialog(String title,String xml){
        try {
            dialog = new Dialog<>();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(xml));
            DialogPane winner = fxmlLoader.load();
            
            dialog.setDialogPane(winner);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            dialog.setTitle(title);
            dialog.show();
        } catch (IOException ex) {
            Logger.getLogger(PlayerVsPlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean checkWin(List<Integer> cells){
        if(cells.contains(0)&&cells.contains(1)&&cells.contains(2)||
            cells.contains(3)&&cells.contains(4)&&cells.contains(5)||
            cells.contains(6)&&cells.contains(7)&&cells.contains(8)||
            cells.contains(0)&&cells.contains(3)&&cells.contains(6)||
            cells.contains(1)&&cells.contains(4)&&cells.contains(7)||
            cells.contains(2)&&cells.contains(5)&&cells.contains(8)||
            cells.contains(0)&&cells.contains(4)&&cells.contains(8)||
            cells.contains(2)&&cells.contains(4)&&cells.contains(6))
            return true;
        else
            return false;
    } 
    
    public void setPlayersNames(String X,String O){
        xPlayerName.setText(X);
        oPlayerName.setText(O);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myGird = new ArrayList<ImageView>();
        myGird.add(b0);
        myGird.add(b1);
        myGird.add(b2);
        myGird.add(b3);
        myGird.add(b4);
        myGird.add(b5);
        myGird.add(b6);
        myGird.add(b7);
        myGird.add(b8);
        
        XOImages = new ArrayList<Image>();
        XOImages.add(new Image(getClass().getResourceAsStream("/images/x.png")));
        XOImages.add(new Image(getClass().getResourceAsStream("/images/oO.png")));
        
        myCells = new ArrayList<Integer>();
        otherPlayerCells = new ArrayList<Integer>();
    }    
    
}
