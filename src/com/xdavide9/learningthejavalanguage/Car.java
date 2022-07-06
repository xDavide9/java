package com.xdavide9.learningthejavalanguage;

public interface Car {

    int speedLimit = 130;   //a constant which is automatically public, static and final

    boolean isFasterThan(Car car); //a method for comparing speed of cars, note that Car is being used as a type

    int getSpeed();

    void setSpeed(int speed);

    boolean isTooFast();

    default void sayHi () {
        System.out.println("hello, this method was added after the interface was used, but the classes that implement it didn't break");
    }

}
