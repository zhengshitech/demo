package com.example.tdd2.hello.entity;


/**
 * Created by zhengqiang on 2017/11/7 20:32.
 * desc:
 */
public class User {
    private int id ;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
