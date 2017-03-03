/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram.utility;

import edu.lfa.networksocketprogram.DAO.UserDAO;
import edu.lfa.networksocketprogram.DAO.UserDAOImp;
import edu.lfa.networksocketprogram.entity.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import edu.lfa.networksocketprogram.entity.User;
/**
 *
 * @author charm_000
 */
public class ClientListener extends Thread {

    Socket client;
    ClientHandler cHandler;
    BufferedReader reader;
    PrintStream ps;
    UserDAO userDAO;

    public ClientListener(Socket client, ClientHandler cHandler) throws IOException {
        this.client = client;
        this.cHandler=cHandler;
        ps = new PrintStream(client.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        userDAO = new UserDAOImp();
    }

    @Override
    public void run() {
        try {

            ps.println("WELCOME SATHI HARU CLIENT SERVER MA HAHAHA");
            System.out.println("ADDRESS" + client.getLocalAddress());
            while(doLogin()!=true){
                ps.println("INVALID USER RETRY AGAIN");
               
                
            }
            doChat();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public boolean doLogin() throws IOException {
        ps.println("Tapaiko name lekhnuhos");
        String name = reader.readLine();
        ps.println("Tapaiko password lekhnuhos");
        String pass = reader.readLine();
      
        User user = userDAO.login(name, pass);
        if(user!=null){
            ps.println("WELCOME "+name);
             cHandler.add(new Client(name,client));
            return true;
        }
        return false;
    }
    public void doChat() throws IOException{
        while(true){
            String message =reader.readLine();
            Client sender = cHandler.getBySocket(client);
            cHandler.broadcrastMessage(client,sender.getName()+" says => "+message);
        }
    }
}
