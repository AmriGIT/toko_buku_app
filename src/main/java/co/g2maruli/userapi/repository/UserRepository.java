/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.g2maruli.userapi.repository;

import co.g2maruli.userapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer>{
    
    public User getUserByUsername(String username);

}
