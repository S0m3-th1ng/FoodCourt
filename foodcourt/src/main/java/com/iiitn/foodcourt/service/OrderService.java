package com.iiitn.foodcourt.service;

import com.iiitn.foodcourt.Exception.NotFoundException;
import com.iiitn.foodcourt.model.Ordertable;
import com.iiitn.foodcourt.model.Ordertable;
import com.iiitn.foodcourt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Ordertable> getAllOrders(){
        List<Ordertable> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return  orders;
    }
    public Ordertable getOrderById(int id){
        return orderRepository.findById(id).orElseThrow(()->new NotFoundException("Order by id " + id + "was not found"));
    }
    public  Ordertable addOrder(Ordertable order){
        return orderRepository.save(order);
    }
    public  Ordertable updateOrder(Ordertable order,int id){
        Ordertable temp = getOrderById(id);
        if (temp != null)
            return orderRepository.save(order);
        return order;
    }
    public  void deleteOrder(Ordertable order){
        this.deteleOrderById(order.getId());
    }
    public void deteleOrderById(int id){
        orderRepository.deleteById(id);
    }
}
