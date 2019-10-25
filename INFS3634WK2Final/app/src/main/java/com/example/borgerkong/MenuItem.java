package com.example.borgerkong;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private int itemID;
    private int image;
    private String name;
    private double price;
    private String description;
    private int OrderQuantity;

// this constructor only requires the itemID and no other attributes like the below constructor)
    public MenuItem(int itemID) {
        this.itemID = itemDatabase.getMenuItemByID(itemID).getItemID();
        this.image = itemDatabase.getMenuItemByID(itemID).getImage();
        this.name = itemDatabase.getMenuItemByID(itemID).getName();
        this.price = itemDatabase.getMenuItemByID(itemID).getPrice();
        this.description = itemDatabase.getMenuItemByID(itemID).getDescription();
        this.OrderQuantity = itemDatabase.getMenuItemByID(itemID).getOrderQuantity();
    }

// constructor which requires all the attributes which is identified in the itemDatabase
    public MenuItem(int itemID, int image, String name, double price, String description, int OrderQuantity) {
        this.itemID = itemID;
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.OrderQuantity = OrderQuantity;
    }


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }


}



