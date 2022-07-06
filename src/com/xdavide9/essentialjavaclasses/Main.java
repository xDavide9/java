package com.xdavide9.essentialjavaclasses;

import java.io.IOException;

public class Main {

    //understanding the hierarchy of files and how basic commands in an os work is crucial when working with computer
    //even if this tutorial is on java specifically it provides general understanding and definition which prove to be really useful

    public static void main(String[] args) throws InterruptedException, IOException {
        //new Exceptions();
        //new BasicIO();
        new Concurrency();

        //note on exception in the main method:
        //File file = new File("");
        //file.createNewFile();
        //this method has "throws IOException" in its declaration
        //and that's how you know you have to handle the exception
        //UNLESS your main method throws the same exception
        //because when using the throws keyword the compiler looks through the call stack
        //(all the methods that call each other to get to the exception-generating code)
        //recursively (bot to top) for an exception handler (try and catch) but the main method
        //is at the top of the call stack meaning no method is going to handle the exception if it occurs
        //THEREFORE: code stops to run know because InterruptedException is a checked exception

        //example of the call stack (which is never going to be reached):
        //method1();
    }

    /*
    static void method1() throws IOException {
        method2();
        //since this method calls method2 which generates the exception
        //it must either handle it or notify the compiler it throws the exception
        //(int this example it throws it instead of handling it with a try and catch)
    }

    static void method2() throws IOException {
        //method that produces the exception
        File file = new File("");
        file.createNewFile();
    }
     */
}

