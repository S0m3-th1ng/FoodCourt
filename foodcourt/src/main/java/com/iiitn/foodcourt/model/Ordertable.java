package com.iiitn.foodcourt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ordertable {
    @Id
    @GeneratedValue()
    @Column(nullable = false,updatable = false)
    private int id;
    private  String order_placed_time;
    private String order_delivery_time;

    public Ordertable(int id, String order_placed_time, String order_delivery_time) {
        this.id = id;
        this.order_placed_time = order_placed_time;
        this.order_delivery_time = order_delivery_time;
    }

    public Ordertable() {

    }

    public int getId() {
        return id;
    }

    public String getOrder_placed_time() {
        return order_placed_time;
    }

    public String getOrder_delivery_time() {
        return order_delivery_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_placed_time(String order_placed_time) {
        this.order_placed_time = order_placed_time;
    }

    public void setOrder_delivery_time(String order_delivery_time) {
        this.order_delivery_time = order_delivery_time;
    }

    @Override
    public String toString() {
        return "Ordertable{" +
                "id=" + id +
                ", order_placed_time='" + order_placed_time + '\'' +
                ", order_delivery_time='" + order_delivery_time + '\'' +
                '}';
    }
}
