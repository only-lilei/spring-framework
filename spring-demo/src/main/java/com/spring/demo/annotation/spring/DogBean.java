package com.spring.demo.annotation.spring;

public class DogBean {
 
    private String name;
 
    private String basePackage;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPackage() {
        return basePackage;
    }
 
    public void setPackage(String basePackage) {
        this.basePackage = basePackage;
    }
 
    @Override
    public String toString() {
        return "DogBean{" +
                "name='" + name + '\'' +
                ", basePackage='" + basePackage + '\'' +
                '}';
    }

