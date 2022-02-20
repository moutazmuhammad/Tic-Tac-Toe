/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author amr
 */
public class Client {
    Socket mysocket;
    DataInputStream dis;
    PrintStream ps;

    public Client() {
        try {
            mysocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mysocket.getInputStream());
            ps = new PrintStream(mysocket.getOutputStream());
            
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                        JSONObject j = new JSONObject(dis.readLine());
                        System.out.println(j);
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                }
            }).start();
            
            JSONObject js = new JSONObject();
            js.put("type", ClientMsg.SIGNIN);
            js.put("username", "Computer");
<<<<<<< HEAD
            js.put("passwd", "comput");
=======
            js.put("passwd", "compute");
>>>>>>> 5773be4066b3e055100994326d28633e649bbf1e
            ps.println(js);
            
            js.clear();
            
            js.put("type", ClientMsg.SIGNIN);
            js.put("username", "Computer");
            js.put("passwd", "computer");
            ps.println(js);
            js.clear();
            
<<<<<<< HEAD
            js.clear();
            js.put("type", ClientMsg.GET_LEADERBOARD);
            ps.println(js);
=======
>>>>>>> 5773be4066b3e055100994326d28633e649bbf1e
            
            
            
           
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Client();
    }    
}
