package com.delivery.chaze.chazedelivery.models;

import java.util.ArrayList;

public class Orders {
    String name,phone,address;
    ArrayList<Shops> shopList;

    public Orders(String name, String phone, String address, ArrayList<Shops> shopList) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.shopList = shopList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Shops> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<Shops> shopList) {
        this.shopList = shopList;
    }
}
