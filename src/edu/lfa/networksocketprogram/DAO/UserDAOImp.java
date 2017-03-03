
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram.DAO;

import edu.lfa.networksocketprogram.entity.User;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author charm_000
 */
public class UserDAOImp implements UserDAO {
    List<User> users = new ArrayList<>();
            @Override
    public User login(String name, String password) {
      for(User u : getAll()){
          if(u.getUsername().equals(name)&&u.getPassword().equals(password)){
              return u;
              
      }
         
    }
       return null;
    }

    @Override
    public List<User> getAll() {
        users.add(new User(1, "Charmin", "shakya"));
        users.add(new User(1, "Sushil", "dhakal"));
        return users;
    }
    
}
