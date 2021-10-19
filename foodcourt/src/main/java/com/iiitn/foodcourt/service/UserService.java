package com.iiitn.foodcourt.service;

import com.iiitn.foodcourt.Exception.NotFoundException;
import com.iiitn.foodcourt.model.User;
import com.iiitn.foodcourt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return  users;
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User by id " + id + "was not found"));
    }
    public  User addUser(User user){
        return userRepository.save(user);
    }
    public  User updateUser(User user,int id){
        User temp = getUserById(id);
        if (temp != null)
            return userRepository.save(user);
        return user;
    }
    public  void deleteUser(User user){
        this.deteleUserById(user.getId());
    }
    public void deteleUserById(int id){
        userRepository.deleteById(id);
    }
}
