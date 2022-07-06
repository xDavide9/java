package com.xdavide9.learningthejavalanguage;

/**
 * This is a class used to showcase anonymous classes
 *
 * @author Davide
 * @see Main
 */
public class AnonymExample {

    @Info (
            author = "Davide",
            lastModified = "9/16/2021",
            lastModifiedBy = "Davide"
    )

      interface Greetings{
        void sayHi();
    }

    public AnonymExample() {
        Greetings federico = new Greetings() {
            //anonymous class is a local class with a single use and without a name, you create the reference of it immediately and use an interface or
            //class to extend as a "Data Type", then open curly braces and create methods inside there.

            //federico is going to be only object of the anonymous class (local class with only one use) which implements the Greetings interface
            @Override
            public void sayHi() {
                System.out.println("Hello! from anonymous class");
            }
            //a lambda expression could be used here too because there is only 1 method in the anonymous class
            //but if you add more methods that is not possible anymore
        };

        federico.sayHi();

        //side to side comparison between anonymous and local classes

        class Felicitation implements Greetings {
            @Override
            public void sayHi() {
                System.out.println("Hello! from local class");
            }
        }

        Felicitation marco = new Felicitation();
        marco.sayHi();
        Felicitation antonio = new Felicitation();
        antonio.sayHi();
        //here you can create more objects from the class while with anonymous classes you can't (they can only be used once)
    }



}
