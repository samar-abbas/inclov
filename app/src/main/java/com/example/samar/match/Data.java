package com.example.samar.match;

/**
 * Created by Samar on 01/12/2016.
 */

public class Data {
    private String image, age;
    int name;

    public Data() {
    }

    public Data(String title, int genre, String year) {
        this.image = title;
        this.name = genre;
        this.age = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String name) {
        this.image = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
