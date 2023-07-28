package com.example.shoppingverse.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level  = AccessLevel.PRIVATE)
@Builder
@Table(name = "cart")

public class Cart {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    int cartTotal;

    @OneToOne
            @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    public Cart(int id, int cartTotal, Customer customer, List<Item> items) {
        this.id = id;
        this.cartTotal = cartTotal;
        this.customer = customer;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
