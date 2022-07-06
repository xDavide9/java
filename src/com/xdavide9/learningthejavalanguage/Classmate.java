package com.xdavide9.learningthejavalanguage;

public record Classmate(String name, String surname, int age) {

    //in a record you pass some parameters and you can access them via auto-generated methods
    //can also create other methods within the record

    public void greetings() {
        System.out.println("Hello, my name is " + name + " " + surname + " and I'm " + age);
    }

    public String getFullName() {
        return name + " " + surname;
    }



}


