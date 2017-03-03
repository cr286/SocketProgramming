/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram.utility;

import java.util.List;
import edu.lfa.networksocketprogram.entity.Client;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author charm_000
 */
public class ClientHandler {
    List<Client> clients = new ArrayList<>();
    
    /**
     *
     */
    public List<Client> getall() {
    return clients;
    }
    public boolean add(Client c){
        clients.add(c);
        return true;
        
    }  
    public Client GetByName(String name){
        for(Client c: clients){
            if(c.getName().equalsIgnoreCase(name)){
            
                return c;
            }
        } 
        return null;
    }
    
    public Client getBySocket(Socket client){
        for(Client c: clients){
            if(c.getClient()==client){
                return c;
            }
           
        }
        return null;
    }
    public void broadcrastMessage(Socket client, String message)throws IOException{
        for(Client c : clients){
            PrintStream ps = new PrintStream(c.getClient().getOutputStream());
            ps.println(message);
        }
            
    }
      
}