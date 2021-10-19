package com.iiitn.foodcourt.repository;

import com.iiitn.foodcourt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
