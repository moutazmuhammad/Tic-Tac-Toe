/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapplication;

import db.Player;
import db.database;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author amr
 */
public class ClientHandler extends Thread{
    
    DataInputStream dis;
    PrintStream ps;
    database db;
    JSONObject request,response;
    Player player;
    static Vector<ClientHandler> clientsVector = new Vector<ClientHandler>();
    
    public ClientHandler(Socket sc,database _db){
        db = _db;
        response = new JSONObject();
        try {
            ps = new PrintStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run(){
        if(ServerApplication.server_status == Status.ON)
        {
            if(log()){
                clientsVector.add(this);
            }else{
                return;
            }
        }
        else{
            ps.println("server is closed");
            closeConnection();
            return;
        }
        
        while(true){
            try {
                String re = dis.readLine();
                if(re == null)
                {
                    clientsVector.remove(this);
                    closeConnection();
                    return;
                }
                JSONObject request = new JSONObject(re);
                System.out.println(request);
                ClientMsg msg = request.getEnum(ClientMsg.class,"type");
                switch (msg) {
                    case GET_LEADERBOARD:
                        get_leaderboard();
                        break;
                    case GET_ONLINE_PLAYERS:
                        get_online_players();
                        break;
                    case CLOSE_CONNECTION:
                        clientsVector.remove(this);
                        closeConnection();
                        return;
                }
               
           } catch (IOException ex) {
               Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
   
    boolean log(){
        while(true){
        try {
            request = new JSONObject(dis.readLine());
            ClientMsg msg = request.getEnum(ClientMsg.class,"type");
            switch (msg) {
                case SIGNIN:
                    if(signIn(request))
                        return true;
                case SIGNUP:
                    if(signUp(request))
                        return true;
                case CLOSE_CONNECTION:
                    closeConnection();
                    return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    void get_leaderboard(){
        
    }
    
    void get_online_players(){
        JSONObject players = new JSONObject();
        for(ClientHandler c : clientsVector){
            if(c!=this)
                players.put(c.player.getUsername(), c.player.getId());
        }
        response.clear();
        response.put("type", ClientMsg.GET_ONLINE_PLAYERS);
        response.put("players", players);
        ps.println(response);
    }
    
    boolean signIn(JSONObject request){
        int r = db.signIn(request.getString("username"), request.getString("passwd"));
        if(r==0){
            response.clear();
            response.put("type", ClientMsg.SIGNIN);
            response.put("id", 0);
            ps.println(response);
            return false;
        }
        else{
            player = db.getPlayerProfile(r);
            response.clear();
            response.put("type", ClientMsg.SIGNIN);
            response.put("id", player.getId());
            response.put("score", player.getScore());
            response.put("loses", player.getWins());
            response.put("wins", player.getLosses());
            ps.println(response);
            return true;
        }
    }

    boolean signUp(JSONObject request){
        int r = db.signUp(request.getString("username"), request.getString("passwd"));
        if(r==0){
            response.clear();
            response.put("type", ClientMsg.SIGNUP);
            response.put("id", 0);
            ps.println(r);
            return false;
        }
        else{
            player = db.getPlayerProfile(r);
            response.clear();
            response.put("type", ClientMsg.SIGNUP);
            response.put("id", player.getId());
            ps.println(r);
            return true;
        }
    }

    void closeConnection(){
        try {
            ps.println("closing connection");
            dis.close();
            ps.close();
            stop();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeServer(){
        for(ClientHandler c : clientsVector){
            c.closeConnection();
        }
        clientsVector.clear();
    }
    
    void invite(){

    }

}
