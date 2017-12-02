package com.zc.json.bean;

/**
 * Created by zc on 2017/12/2.
 */

public class JsonStrBean {
    /**
     * 此处按下Alt + Insert选择GsonFormat，粘贴json字符串即可自动生成
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

    //构造方法
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

    //重写toString方法
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
