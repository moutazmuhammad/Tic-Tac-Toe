
package ticTac;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class SingleGameScreenController implements Initializable {
    
    private int computerPosition=0;
    
    private int turnPosition = 2; //To get the correct position of X and O
    
    @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button playAgain;

    private int buttonPosition[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    private int xPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //player
    private int oPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //computer
        
      
    @FXML
    private void b0ButtonAction(ActionEvent event) throws InterruptedException {
        
        if (buttonPosition[0]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b0.setText("X");
               
                buttonPosition[0]=1;
                xPlayerWon[0]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b1ButtonAction(ActionEvent event) {
        
        if (buttonPosition[1]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b1.setText("X");
               
                buttonPosition[1]=1;
                xPlayerWon[1]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }
                
                                
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b2ButtonAction(ActionEvent event) {
        
        if (buttonPosition[2]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b2.setText("X");
               
                buttonPosition[2]=1;
                xPlayerWon[2]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }             
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b3ButtonAction(ActionEvent event) {
        
        if (buttonPosition[3]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b3.setText("X");
               
                buttonPosition[3]=1;
                xPlayerWon[3]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b4ButtonAction(ActionEvent event) {
        
        if (buttonPosition[4]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b4.setText("X");
               
                buttonPosition[4]=1;
                xPlayerWon[4]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b5ButtonAction(ActionEvent event) {
        
        if (buttonPosition[5]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b5.setText("X");
               
                buttonPosition[5]=1;
                xPlayerWon[5]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }              
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b6ButtonAction(ActionEvent event) {
        
        if (buttonPosition[6]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b6.setText("X");
               
                buttonPosition[6]=1;
                xPlayerWon[6]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b7ButtonAction(ActionEvent event) {
        
        if (buttonPosition[7]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b7.setText("X");
               
                buttonPosition[7]=1;
                xPlayerWon[7]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b8ButtonAction(ActionEvent event) {
        
        if (buttonPosition[8]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b8.setText("X");
               
                buttonPosition[8]=1;
                xPlayerWon[8]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    System.out.println("X is the winer!");
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        System.out.println("O is the winer!");
                    }  
                }                
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
   
    
    private void computerPlayer(){
        Vector<Integer> emptyPositions = new Vector<>(); //empty postions
        
        for (int index=0; index < buttonPosition.length; index++){
            if (buttonPosition[index] == 0){
                emptyPositions.add(index);
            }
        }
        computerPosition = (int) (Math.random()*emptyPositions.size()); //To get Random position
        System.out.println("computerPosition" + computerPosition);
     
        if (! emptyPositions.isEmpty()){
            
            turnPosition++; //To Skep the next index
            
            if (emptyPositions.get(computerPosition) == 0){
                b0.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 1){
                b1.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 2){
                b2.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 3){
                b3.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 4){
                b4.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 5){
                b5.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 6){
                b6.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 7){
                b7.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 8){
                b8.setText("O");
            }
            
            oPlayerWon[emptyPositions.get(computerPosition)]=1;
            buttonPosition[emptyPositions.get(computerPosition)]=1;
        }
    }
    
    private int xPlayerWonGame(){
        if (xPlayerWon[0]==1 && xPlayerWon[1]==1 && xPlayerWon[2]==1){
            return 1;
        }
        if (xPlayerWon[3]==1 && xPlayerWon[4]==1 && xPlayerWon[5]==1){
            return 1;
        }
        if (xPlayerWon[6]==1 && xPlayerWon[7]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[0]==1 && xPlayerWon[3]==1 && xPlayerWon[6]==1){
            return 1;
        }
        if (xPlayerWon[1]==1 && xPlayerWon[4]==1 && xPlayerWon[7]==1){
            return 1;
        }
        if (xPlayerWon[2]==1 && xPlayerWon[5]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[0]==1 && xPlayerWon[4]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[2]==1 && xPlayerWon[4]==1 && xPlayerWon[6]==1){
            return 1;
        }
        return 0;
    }
    
    int computerWonGame(){
        if (oPlayerWon[0]==1 && oPlayerWon[1]==1 && oPlayerWon[2]==1){
            return 1;
        }
        if (oPlayerWon[3]==1 && oPlayerWon[4]==1 && oPlayerWon[5]==1){
            return 1;
        }
        if (oPlayerWon[6]==1 && oPlayerWon[7]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[0]==1 && oPlayerWon[3]==1 && oPlayerWon[6]==1){
            return 1;
        }
        if (oPlayerWon[1]==1 && oPlayerWon[4]==1 && oPlayerWon[7]==1){
            return 1;
        }
        if (oPlayerWon[2]==1 && oPlayerWon[5]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[0]==1 && oPlayerWon[4]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[2]==1 && oPlayerWon[4]==1 && oPlayerWon[6]==1){
            return 1;
        }
        return 0;
    }
    
    @FXML
    private void playAgainButtonAction(ActionEvent event) {
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        
        turnPosition = 2;
        for (int i=0 ; i<9 ; i++){
            buttonPosition[i] = 0;
            xPlayerWon[i] = 0;
            oPlayerWon[i] = 0;
        }
        
    }
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void ScreenshotButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void PauseButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
