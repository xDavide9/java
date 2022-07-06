package com.xdavide9.javadeployment;

public class SelfContainted {

    SelfContainted() {
        //a self contained application behaves like any other native application
        //and it provides the user with the jre needed to run the applications
        //so that he has to install only that
        //the java packager command creates the bundle for these applications
        //also Ant can be used

        //these application really look like those from the real world
        //where you have an installer (specific for each os, exe for windows etc.)

        //generally for smaller applications even a single jar file is necessary
        //and additional resources like icons can be used

        //apache ant can be used for creating these applications but there are many tools
        //for now lets see how to create an executable which just runs on windows (.exe)
        //without having the user install anything
        //https://www.youtube.com/watch?v=Mr_TdPuF-4g

        //also maven is a good option
        //to package best is to create an installer with inno setup which will create a folder in programs file
        //and links to the main executable located in that folder with all the resources needed
    }

}
