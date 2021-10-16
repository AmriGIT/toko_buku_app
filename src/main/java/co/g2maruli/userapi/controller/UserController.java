package co.g2maruli.userapi.controller;

import co.g2maruli.userapi.entity.User;
import co.g2maruli.userapi.model.Register;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import co.g2maruli.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("localhost:3000/control-panel")
public class UserController {
    
    @Autowired
    UserService userService;
    
    private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    
    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody Register register){

        User user = new User();
        user.setUsername(register.getUsername());
        user.setPassword(bcrypt.encode(register.getPassword()));
        userService.save(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> showUser(){
        Iterable<User> users = userService.findAll();
        List<User> userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());

        return ResponseEntity.ok(userList);
    }

    
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable (name="id") Integer id){
        User user = userService.findById(id);
        userService.delete(user);
        
        return ResponseEntity.ok("user deleted");
    }
 
}