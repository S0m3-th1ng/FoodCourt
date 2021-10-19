package com.iiitn.foodcourt.Controller;

import com.iiitn.foodcourt.model.Ordertable;
import com.iiitn.foodcourt.model.Ordertable;
import com.iiitn.foodcourt.model.User;
import com.iiitn.foodcourt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Ordertable> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/find/{id}")
    public  Ordertable getOrderById(@PathVariable("id") int id){
        return  orderService.getOrderById(id);
    }
    @PostMapping("/add")
    public  Ordertable addOrder(@RequestBody Ordertable order){
        return  orderService.addOrder(order);
    }
    @PutMapping("/update/{id}")
    public Ordertable updateOrder(@RequestBody Ordertable order,@PathVariable("id") int id){
        return  orderService.updateOrder(order,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable int id){
        orderService.deteleOrderById(id);
    }
}
