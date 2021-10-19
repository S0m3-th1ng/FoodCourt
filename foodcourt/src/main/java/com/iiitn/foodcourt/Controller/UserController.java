package com.iiitn.foodcourt.Controller;

import com.iiitn.foodcourt.model.User;
import com.iiitn.foodcourt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/find/{id}")
    public  User getUserById(@PathVariable("id") int id){
        return  userService.getUserById(id);
    }
    @PostMapping("/add")
    public  User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") int id){
        return  userService.updateUser(user,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deteleUserById(id);
    }

}
