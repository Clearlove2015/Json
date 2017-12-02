package com.zc.fastjson.bean;

/**
 * Created by zc on 2017/12/2.
 */

public class JsonStrBean {
    /**
     * 在此处按下Alt + Insert，选择GsonFormat即可自动生成
     */

    /**
     * id : 2
     * name : 大虾
     * price : 12.3
     * imagePath : http://192.168.10.165:8080/L05_Server/images/f1.jpg
     */

    private int id;
    private String name;
    private double price;
    private String imagePath;

    public JsonStrBean(int id, String name, double price, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "JsonStrBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
