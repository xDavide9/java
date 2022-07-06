package com.xdavide9.essentialjavaclasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {

    Exceptions() {
        //this covers the essential java classes trail from the official java tutorials website

        //EXCEPTION
        /*
        Definition:
        An exception is an event, which occurs during the execution of a program,
        that disrupts the normal flow of the program's instructions.
         */
        /*
        When an error occurs within a method, the method creates an object and hands it off to the runtime system.
        The object, called an exception object, contains information about the error, including its type and the state of the program when the error occurred.
        Creating an exception object and handing it to the runtime system is called throwing an exception.
         */

        //an exception is an error in the program
        //when a method produces an error an object with information about this error is created
        //which is called "exception object" and handling it in runtime is called "throwing an exception"

        //in order to throw the exception then the runtime system looks for a method with specific code to do so
        //going backwards in the call stack which is the list of methods that has been called to call the method that produces the error
        //and this specific code is an exception handler.
        //if the type is right then the exception handler catches the exception object
        //the exception is said to be forwarded to methods that could have the exception handler within the call stack by methods that don't have it
        //if the exception is never caught then bad things might happen
        //the graphics on the site are very accurate

        //the catch or specify requirement
        //means that code that might produce an exception should either be enclosed withing a try block
        //or the method that produces it should have a throws clause with the type of exception to be caught\
        //code that doesn't honor this requirement fails to compile
        //but not all exception are subject to the requirement

        //there are 3 types of exceptions:
        //1) the first one is the checked exception, which is an exception that well written code should handle and can anticipate and recover from
        //for example when passing a file to the FileReader class constructor you must be sure of passing an existing file
        //otherwise a FileNotFound exception is going to be thrown and that needs to be handled
        /*
        Checked exceptions are subject to the Catch or Specify Requirement.
        All exceptions are checked exceptions, except for those indicated by Error, RuntimeException, and their subclasses.
         */

        //2) the second type is the error, which is something that the application can't recover from and that is usually caused by something else
        //for example assume that an object of FileReader is successfully created but then it's not possible to read the file because of a hardware
        //malfunction, then the compiler will throw java.io.IOError
        /*
        Errors are not subject to the Catch or Specify Requirement. Errors are those exceptions indicated by Error and its subclasses.
         */

        //3) the last type is the runtime exception which probably translates in mistakes made by the programmer,
        //because this is an exception that is internal in the program and that it's not usually possible to recover from
        //for example assume you were going to pass a null object in the FileReader constructor, then the constructor will
        //throw a NullPointerException which may be caught but it makes more sense to fix the bug in the first place
        /*
        Runtime exceptions are not subject to the Catch or Specify Requirement.
        Runtime exceptions are those indicated by RuntimeException and its subclasses.
         */

        //errors and runtime exception (the second and third type) are collectively known as unchecked exceptions

        //within the try block put code that might produce the exception
        //within catch block put code that is going to be run if the exception is thrown (can be a lot of things
        //not just print the exception and exit, like have the user make a choice)
        //within finally block put clean up code that is going to be run either way (closing a stream item for example)

        //this use of finally is really interesting cause you can close streams or resources which are classes that implement Closeable interface

        //example
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("non-existent-file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();        //this method displays the exception details, always useful
            System.out.println("The file didn't exist");
        } finally {
            System.out.println("I am always run ihih");
            if (fileReader != null) {
                try {
                    fileReader.close();
                    System.out.println("closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("already closed");
            }
        }

        //you can also throw exception from a method with the "throw" statement,
        //not to be confused with "throws" which is an alternative to try-catch blocks
        //and must be put in the declaration of a method

        //example
        throw new IllegalAccessError(); //throwing an error because it won't break the program because together with Runtime Exception
        //they are unchecked exceptions

        //the throw statement requires an object of a subclass of Throwable, the base class for Errors and Exceptions
        //Exception has also RuntimeExceptions as its subclasses

        //in the end:
        //it is also possible to create your own exception classes as subclasses of Throwable
        //you can also chain exception thanks to the throw statement

        //SUMMARY

        /*
        A program can use exceptions to indicate that an error occurred. To throw an exception,
        use the throw statement and provide it with an exception object — a descendant of Throwable —
        to provide information about the specific error that occurred. A method that throws an uncaught,
        checked exception must include a throws clause in its declaration.

        A program can catch exceptions by using a combination of the try, catch, and finally blocks.

        The try block identifies a block of code in which an exception can occur.
        The catch block identifies a block of code, known as an exception handler, that can handle a particular type of exception.
        The finally block identifies a block of code that is guaranteed to execute, and is the right place to close files, recover resources, and otherwise clean up after the code enclosed in the try block.
        The try statement should contain at least one catch block or a finally block and may have multiple catch blocks.

        The class of the exception object indicates the type of exception thrown.
        The exception object can contain further information about the error, including an error message.
        With exception chaining, an exception can point to the exception that caused it,
        which can in turn point to the exception that caused it, and so on.
         */
    }
}

