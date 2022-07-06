package com.xdavide9.learningthejavalanguage;

//enum is a list where you can also define functions and method (very similar to a class), but the references of the enum are already set
//(ANDREA, MARCO, FEDERICO...), you can't create more cause it makes no sense otherwise it would be a class)

public enum Friends {

    ANDREA(180),
    FEDERICO(170),
    MARCO(180);

    private int height;

    Friends(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
