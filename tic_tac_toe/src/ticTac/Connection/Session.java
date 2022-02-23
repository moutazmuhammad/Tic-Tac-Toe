package ticTac.Connection;

import controller.ControlManager;
import controller.LeaderBoardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.json.JSONObject;
import ticTac.Connection.msgType;
import controller.LoginController;
import controller.MainScreen;
import controller.Player;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
<<<<<<< HEAD
import javafx.scene.control.Label;
=======
>>>>>>> 9c38e0464ce65a082dc2eeeb057115163719b7be
import org.json.JSONArray;

public class Session extends Thread{
    private Stage stage;
    private Socket socket;
    private DataInputStream inputStream;
    private PrintStream printStream;
    public ControlManager controlManager;
    public Player player;
    
    JSONObject Message ;
    boolean Connected =false;
    public boolean viewOnlinePlayers = false;
    public boolean loged = false;


    public Session(Stage stage)
    {
        controlManager = new ControlManager();
        openConnection();
        this.stage = stage;
        start();
    }

    public void openConnection(){
        try {
            socket = new Socket("127.0.0.1",5005);
            printStream = new PrintStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            Connected = true;
        } catch (IOException e) {
            Connected = false;
        }
    }

    public void CloseConnection(){
        Message = new JSONObject();
        Message.put("type",msgType.CLOSE_CONNECTION);
        String jsonStr = Message.toString();
        printStream.println(jsonStr);
        Connected = false;
        try {
            printStream.close();
            inputStream.close();
            socket.close();
            stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void StartCommunication() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (Connected){
                    try {
                        Message = new JSONObject(inputStream.readLine());
                        MessageHandler(Message);
                    } catch (IOException e) {
                       Connected = false;
                       break;
                    }
                }

                try {
                    socket.close();
                    inputStream.close();
                    printStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public FXMLLoader changeScene(String xml)
    {
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(xml));
            Parent fxmlViewChild = loader.load();
            Scene fxmlViewScene = new Scene(fxmlViewChild);
            Platform.runLater(new Runnable() {
            @Override public void run() {
                stage.setScene(fxmlViewScene);
                stage.show();
                }
            });
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loader;
    }

    public void signInRequest(String Username , String Password)
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.SIGNIN);
        js.put("username", Username);
        js.put("passwd", Password);
        printStream.println(js);
    }
    
    private void signInResponse(JSONObject Message)
    {
        int id = Message.getInt("id");
        if(id == 0 )
        {
            controlManager.getLoginController().login_failre();
        }
        else
        {
            
            MainScreen.session.controlManager.setInvitationController(changeScene("/fxml/PlayerInvitationScreen.fxml"));
            loged = true;
            MainScreen.session.viewOnlinePlayers = true;
            MainScreen.session.getOnlinePlayersRequest();
            player = new Player();
            player.setID((int) Message.get("id"));
            player.setUsername((String) Message.get("username"));
            player.setScore((int) Message.get("score"));
        }
    }
    

    
    private void signUpResponse(JSONObject Message)
    {
        int id = Message.getInt("id");
        if(id == 0 )
        {
            return;
        }
        else
        {
            changeScene("/fxml/login.fxml");
            return;
        }
    }
    

    public void signUpRequest(String Username , String Password)
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.SIGNUP);
        js.put("username", Username);
        js.put("passwd", Password);
        printStream.println(js);
    }
    
    public void getLeaderboardRequest()
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.GET_LEADERBOARD);
        printStream.println(js);
    }
    
    private void getLeaderboardResponse(JSONObject Message)
    {
        controlManager.setLeaderBoardController(changeScene("/fxml/LeaderBoard.fxml"));
        controlManager.getLeaderBoardController().loadLeaderBoard(Message);
    }
    
    public void getOnlinePlayersRequest()
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.GET_ONLINE_PLAYERS);
        printStream.println(js);
    }
    
    private void getOnlinePlayersResponse(JSONObject Message)
    {
        if(viewOnlinePlayers&&!Message.get("name").toString().equals(",")){
            String[] name = Message.get("name").toString().split(",");
            String[] score = Message.get("score").toString().split(",");
            String[] id = Message.get("id").toString().split(",");
            Player [] playerList = new Player[name.length-1];
            for(int a = 1; a < name.length; a++){
                playerList[a-1] = new Player(name[a],Integer.parseInt(score[a]),Integer.parseInt(id[a]));
            }
            ObservableList<Player> list = FXCollections.observableArrayList(playerList);
            controlManager.getInvitationController().insertOnlinePlayers(list);
        }
    }
    

    public void invitationSendRequest(int id)
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.INVETATION_SEND);
        js.put("reciever id", id);
        printStream.println(js);
    }
    
    private void invitationSendResponse(JSONObject Message)
    {
        if(!viewOnlinePlayers){
            invitationReplyReqest("no", Message.getInt("sender id"));
            return;
        }
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Dialog<ButtonType> dialog = new Dialog<>();
                    FXMLLoader fxmlLoader = new FXMLLoader();
<<<<<<< HEAD
                    fxmlLoader.setLocation(getClass().getResource("/fxml/InvitationDialog.fxml"));
=======
                    fxmlLoader.setLocation(getClass().getResource("/fxml/draw.fxml"));
>>>>>>> 9c38e0464ce65a082dc2eeeb057115163719b7be
                    DialogPane winner = fxmlLoader.load();
                    
                    dialog.setDialogPane(winner);
                    dialog.getDialogPane().getButtonTypes().add(ButtonType.YES);
                    dialog.getDialogPane().getButtonTypes().add(ButtonType.NO);
<<<<<<< HEAD
                    dialog.setTitle("Game Invitation");
                    Label content = new Label(Message.getString("sender name").toUpperCase()+" Invited You to a Game! Would You Like to Accept?");
                    content.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5px");
                    dialog.setGraphic(content);
=======
                    dialog.setTitle("Accept Invetation from "+Message.getString("sender name"));
>>>>>>> 9c38e0464ce65a082dc2eeeb057115163719b7be
                    Optional<ButtonType> result = dialog.showAndWait();
                    if(result.get()==ButtonType.YES){
                        invitationReplyReqest("yes", Message.getInt("sender id"));
                        System.out.println("yes");
                    }
                    else{
                        invitationReplyReqest("no", Message.getInt("sender id"));
                        System.out.println("no");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void invitationReplyReqest(String reply,int id)
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.INVETATION_REPLY);
        js.put("reciever id", id);
        js.put("reply", reply);
        printStream.println(js);
    }
    
    private void invitationReplyResponse(JSONObject Message)
    {
        System.out.println(Message.getString("reply"));
    }
    
    
    public void run(){
        while(true){
            try {
                String re = inputStream.readLine();

                if(re == null)
                {
                    return;
                }
                JSONObject response = new JSONObject(re);
                msgType msg = response.getEnum(msgType.class,"type");
                System.out.println(response);
                switch (msg) {
                    case SIGNIN:
                        signInResponse(response);
                        break;
                    case SIGNUP:
                        signUpResponse(response);
                        break;
                    case GET_LEADERBOARD:
                        getLeaderboardResponse(response);
                        break;
                    case GET_ONLINE_PLAYERS:
                        getOnlinePlayersResponse(response);
                        break;
                    case INVETATION_SEND:
                        invitationSendResponse(response);
                        break;
                    case INVETATION_REPLY:
                        invitationReplyResponse(response);
                        break;
                }

            } catch (IOException ex) {
                Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    //this function needs a server to connect and check for the msg type
    private void MessageHandler(JSONObject message){
        String type = (String) message.get("type");
    }



}
