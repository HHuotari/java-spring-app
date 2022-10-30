package com.huotari.lopputyo.data;

public class Student {
    private int id;
    private String name;
    private static int idCounter=0;

    public Student(){
        this("");
    }

    public Student(String name){
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
