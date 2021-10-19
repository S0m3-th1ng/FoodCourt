package com.iiitn.foodcourt.repository;

import com.iiitn.foodcourt.model.Ordertable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordertable,Integer> {

}
