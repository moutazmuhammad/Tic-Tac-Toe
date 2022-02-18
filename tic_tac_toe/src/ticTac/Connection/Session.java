package ticTac.Connection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONObject;
import ticTac.LeaderBoardController;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Session extends Thread{
    private Stage stage;
    private Socket socket;
    private DataInputStream inputStream;
    private PrintStream printStream;
    JSONObject Message ;
    boolean Connected =false;


    public Session(Stage stage)
    {
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

    public void ChangeScene(String XML)
    {
        Parent fxmlViewChild = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(XML));

            fxmlViewChild = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene fxmlViewScene = new Scene(fxmlViewChild);

      //  Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(fxmlViewScene);

        stage.show();
    }

    public void SignInResponse(JSONObject Message)
    {
        int id = Message.getInt("id");
        if(id == 0 )
        {
            return;
        }
        else
        {
            ChangeScene("mainMenu.fxml");
        }
    }

    public void SignInRequest(String Username , String Password)
    {
        JSONObject js = new JSONObject();
        js.put("type", msgType.SIGNIN);
        js.put("username", "Computer");
        js.put("passwd", "compute");
        printStream.println(js);
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
               // String str = response.toString();
                System.out.println(response);
                msgType msg = response.getEnum(msgType.class,"type");
                switch (msg) {
                    case SIGNIN:
                        SignInResponse(response);
                        break;
                    case SIGNUP:
                      //  test();
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
//        switch (type){
//            case LOGIN:
//        }
    }



}
