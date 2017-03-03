/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram;

import edu.lfa.networksocketprogram.utility.ClientHandler;
import edu.lfa.networksocketprogram.utility.ClientListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.net.ServerSocket;
import java.net.Socket;


public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int port = 2869;
        ClientHandler cHandler = new ClientHandler();
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is Starting at port 2869");
            while(true){
                Socket client = server.accept();
                
                ClientListener listener = new ClientListener(client,cHandler);
                listener.start();
                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
