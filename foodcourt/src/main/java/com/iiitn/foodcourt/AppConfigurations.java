package com.iiitn.foodcourt;


import com.google.gson.Gson;
import com.iiitn.foodcourt.model.Profile;
import com.iiitn.foodcourt.model.User;
import com.iiitn.foodcourt.service.ProfileService;
import com.iiitn.foodcourt.service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@RestController
public class AppConfigurations {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String Home(){
        return  "WelComeHome";
    }
    @GetMapping("addprofiles")
    public String addprofiles() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("profiles.json"));
        JSONArray list = (JSONArray) obj;
        Iterator<JSONObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            System.out.println(jsonObject);
            Gson gson = new Gson();
            Profile profile = gson.fromJson(String.valueOf(jsonObject), Profile.class);
            System.out.println(profile);
            profileService.addProfile(profile);
        }
        return  "Completed";
    }
    @GetMapping("addusers")
    public String addusers() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("users.json"));
        JSONArray list = (JSONArray) obj;
        Iterator<JSONObject> iterator = list.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            System.out.println(jsonObject);
            Gson gson = new Gson();
            User user = gson.fromJson(String.valueOf(jsonObject), User.class);
            System.out.println(user);
            userService.addUser(user);
        }
        return  "Completed";
    }
}
