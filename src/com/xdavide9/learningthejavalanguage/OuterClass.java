package com.xdavide9.learningthejavalanguage;

/**
 * This is a class used to showcase nested classes
 *
 * @author Davide
 * @see Main
 */
public class OuterClass {
    @Info (
            author = "Davide",
            lastModified = "9/16/2021",
            lastModifiedBy = "Davide"
    )

    private String hello = "Hello! from an inner class";

    class InnerClass {
        //inner class is in a class but not a method
        //will be accessed when creating object in a particular way
        void sayHi() {
            System.out.println(hello);
        }
    }

    public OuterClass() {
        //local class is inside a method and depends on it then (preferable imo)
        class LocalClass {
            void sayHi() {
                System.out.println("Hello! from a local class");
            }
        }

        LocalClass localClassInstance = new LocalClass();
        localClassInstance.sayHi();
    }
}
