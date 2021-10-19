package com.iiitn.foodcourt.service;

import com.iiitn.foodcourt.Exception.NotFoundException;
import com.iiitn.foodcourt.model.Profile;
import com.iiitn.foodcourt.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public List<Profile> getAllProfiles(){
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findAll().forEach(profiles::add);
        return  profiles;
    }
    public Profile getProfileById(int id){
        return profileRepository.findById(id).orElseThrow(()->new NotFoundException("Profile by id " + id + "was not found"));
    }
    public  Profile addProfile(Profile profile){
        return profileRepository.save(profile);
    }
    public  Profile updateProfile(Profile profile,int id){
        Profile temp = this.getProfileById(id);
        if (temp != null)
            return profileRepository.save(profile);
        return profile;
    }
    public  void deleteUser(Profile profile){
        this.deteleProfileById(profile.getId());
    }
    public void deteleProfileById(int id){
        profileRepository.deleteById(id);
    }
}
