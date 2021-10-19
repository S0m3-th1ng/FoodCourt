package com.iiitn.foodcourt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;
    private String item;
    private float price;
    private int quantity;
    private  float total_price;

    public Product(int id, String item, float price, int quantity, float total_price) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                '}';
    }
}
