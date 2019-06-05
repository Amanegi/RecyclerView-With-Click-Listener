package com.example.aman_negi.recyclerviewdemo;

/**
 * Created by Aman_Negi on 16-02-2018.
 */

public class SingleRow {
    int image;
    String name, num;

    public SingleRow(int image, String name, String num) {
        this.image = image;
        this.name = name;
        this.num = num;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

}
