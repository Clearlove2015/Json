package com.zc.fastjson.bean;

/**
 * Created by zc on 2017/12/2.
 */

public class JsonArrayBean {
    /**
     * id : 1
     * imagePath : http://192.168.10.165:8080/f1.jpg
     * name : 大虾1
     * price : 12.3
     */

    private int id;
    private String imagePath;
    private String name;
    private double price;

    public JsonArrayBean(int id, String imagePath, String name, double price) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    @Override
    public String toString() {
        return "JsonArrayBean{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
