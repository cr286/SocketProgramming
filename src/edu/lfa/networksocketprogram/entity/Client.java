/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram.entity;

import java.net.Socket;

/**
 *
 * @author charm_000
 */
public class Client {
    
    private String Name;
 
    private Socket client;

   
    
    public Client() {
    }

    public Client(String Name, Socket client) {
        this.Name = Name;
        this.client = client;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

   

   
}
