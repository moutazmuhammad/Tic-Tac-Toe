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
            
            Scanner sc= new Scanner(System.in);
            while(true){
                String str= sc.nextLine();
                ps.println(str);
                System.out.println(dis.readLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Client();
    }    
}
