package com.iiitn.foodcourt.Controller;

import com.iiitn.foodcourt.model.Profile;
import com.iiitn.foodcourt.model.User;
import com.iiitn.foodcourt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/all")
    public List<Profile> getAllUsers(){
        return profileService.getAllProfiles();
    }
    @GetMapping("/find/{id}")
    public  Profile getProfileById(@PathVariable("id") int id){
        return  profileService.getProfileById(id);
    }
    @PostMapping("/add")
    public  Profile addProfile(@RequestBody Profile profile){
        return  profileService.addProfile(profile);
    }
    @PostMapping("/addall")
    public  void addAllProfile(@RequestBody List<Profile> profiles){
        for(Profile profile : profiles){
            profileService.addProfile(profile);
        }
    }

    @PutMapping("/update/{id}")
    public Profile updateProfile(@RequestBody Profile profile,@PathVariable("id") int id){
        return  profileService.updateProfile(profile,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable int id){
        profileService.deteleProfileById(id);
    }
}
