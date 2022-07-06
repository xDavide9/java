package com.xdavide9.learningthejavalanguage;

public class Test implements Car{

    @Override
    public boolean isFasterThan(Car car) {
        return false;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public boolean isTooFast() {
        return false;
    }

    public void ciao() {

    }
}
