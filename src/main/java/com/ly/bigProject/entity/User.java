package com.ly.bigProject.entity;

public class User {

    private  String name;
    private  String sex;
    private  String age;
    private  String hig;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHig() {
        return hig;
    }

    public void setHig(String hig) {
        this.hig = hig;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", hig='" + hig + '\'' +
                '}';
    }
}
