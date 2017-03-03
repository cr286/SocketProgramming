/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.networksocketprogram.DAO;
import edu.lfa.networksocketprogram.entity.User;
import java.util.List;
/**
 *
 * @author charm_000
 */
public interface UserDAO {
    User login(String name, String password );
    List<User> getAll();
    
}
