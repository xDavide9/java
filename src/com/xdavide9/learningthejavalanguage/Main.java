package com.xdavide9.learningthejavalanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//COVERS THE JAVA LANGUAGE BASICS FROM OFFICIAL JAVA TUTORIALS

/*
Some key concepts of the java language

All the files of a java project should be structured in packages (directories) which are specified at the beginning of each .java file

In java, code is written inside functions (also known as methods) which can be called with or without parameters

These methods can be defined inside a class so the first thing to do is to create a class,
in order to create it you have to look at the name of the file (with the .java extension of course) because the class name must be the same of the file

So using the keyword class and the name of time only another element is needed: a code block, which is the space between two {}, inside it you can then create methods and in the methods you can write actual code

The class declaration also may contain access modifiers like public, which allows the class to be accessed from outer packages

An important method is the main method (usually contained in a class called Main, always use the first uppercase letter for a class name but not for a method, where you use camel case, where only the first letter of the consequent words is uppercase but not the first one, e.g. thisIsFun)

the main method is the entrypoint of the java application meaning that when you run your code what runs actually is just the main method and from there you can create another methods and call them from it, this method has a String[] args parameters, those are the command line argument which are the arguments you pass the program when you run it

but what happens when you actually click run in an ide (the text editor where you code), a software called compiler (in java’s case javac) actually turns the .java file in .class files that are written in bytecode (a language that only computers can understand, and that makes java multiplatform) and this bytecode is then run by the computer to perform the functions you assign, this process is called compiling which is also similar to building the project, another thing that happens sometimes is validation, usually performed by the ide that highlights you any syntax error which would cause the application to fail

VARIABLES

variables are containers that store a value in memory, the type of the value store depends on the language and in java you have what you call primitive types which are: byte, short, int, long, float, double, boolean, char. The first 4 (byte, short, int, long)  are for numbers without decimals and are increasing in terms of the size of the number they can store, same for the next two (float, double) that are increasing in size but for numbers with decimals, boolean is either true or false, char is meant to store characters

variables can be declared by specified their type before the name you assign it (like int number; where number is the name you give the variable, and int is the data type which is a primitive type) this is because java is statically typed (meaning that the compiler knows from the beginning which is the type of a variable vs dynamically typed languages where you don’t specify it and it is only determined at runtime, (when you click run)

but where are variables declared? well not only in methods (in that case they would be of local scope, meaning that they can only be accessed from within the method and not outside of it) but also outside of them, but still inside the class block (nothing can be outside of it) and in that case they are global for the entire class

but you usually find other keywords before the type of the variable, those are the access modifiers (public, private, protected) and specify from where they can be accessed:
public means that you can access it from outside the class directly
private does not allow the above, you would need specific methods called getters and setters
protected is important in the context of inheritance

after the name you also find the value of the variable which is preceded by an equals sign, (if you don't do it the value will be the default one, which is not very useful)

therefore, methods can contain variables, and calls to other methods with or without parameters but there are other tools used in the language to build algorithms

LOOPS

loops allow you to run the same code multiple times without having to write it again and again

there are two types of loops: 

for loop, which comes in a general form of 
for (int i = 0; i < 3; i++) {}
the different elements are the for keyword and then inside () you declare a variable (usually i or j) then you set a value that this variable should be less or more of (in this case less, in other words a condition) and then an increment or decrement
What does this mean? it means that the first time i = 0 and the code inside the for is executed  because i < 3 and then i is increment with ++ and now it is 1, so repeat and i is now 2 so repeat and i is 3 but now the code is not executed because 3 < 3 is false of course

while loop is similar but the form is 
while(condition) {} 
so the condition is not managed by the loop

CONTROL FLOW STATEMENTS
also widely known as if
allow you to check for a condition which declares whether the code inside the if statement should be executed, remember {} define the code block
if the condition is false you may include and else statement which also defines a block and is run indeed when the condition is false, you may also include else if statements which define a different condition from the first one

another control flow statement is the switch statement

CLASSES AND OBJECTS
the heart of the java programming language are classes and object, everything as we said is inside a class, but how can you access a class (and therefore what you call its members, all the methods and variables of the class), you do it by creating an object of that class

objects don’t have a specified data type, (you create your own class yourself), and to create them you do the same thing except that you must initialize the object, otherwise you get an exception

from these objects you can access the public member of the class which is the type of that object

MODULES
a way to organize your code and package your code
this code is written itself in a module which has the same name of the root directory
inside this directory you can find all the project files which include your classes, files for the gihub repository
or even ide files, maven files etc
*/

//right before class and methods declarations you can put javadoc comments which will appear in the javadoc
//in order to run javadoc it's possible to either use the javadoc command in a terminal (like intellij's one)
//or use intellij's feature


//this is a javadoc comment: note that it's right before a class declaration
/**
 * This is the Main class of my notes
 *
 * @author Davide
 * @version 1.1
 * @see Info
 * @see Friends
 */
public class Main {

    //annotations, enums, records are like java classes but with some particular features

    //annotation from another class
    @Info (
            author = "Davide",
            lastModified = "29/03/2022",
            lastModifiedBy = "Davide"
    )

    public static void main(String[] args) {
        //to have a long must use "L" or "l" at the end of the number, otherwise you get an integer
        //when using integers "I" or "i" at the end of the number can be omitted
        long myLong = 1_000_000_000_000_000_000L;
        System.out.println("a long number: " + myLong);

        //for numbers in hexadecimal use prefix "0x";
        int hexTen = 0xa;
        System.out.println("a in hexadecimal equals: " + hexTen);

        //for numbers in binary use prefix "0b";
        int binEight = 0b1000;
        System.out.println("1000 in binary equals: " + binEight);

        //to have a float use "F" or "f" at the end of the number, otherwise you get a double
        //when using doubles "D" or "d" at the end of the number can be omitted
        final float PI = 3.14f;
        System.out.println("pi: " + PI);

        //using integers and doubles is okay for most operations

        System.out.println("this line\nis split");
        //different options with \ like \n for a new line

        //an array (short syntax)
        int[] array = {1, 2, 3};

        //array copy method, used to copy an array to another one
        int[] array1 = new int[3];
        System.arraycopy(array, 0, array1, 0, 3);
        //for (int i : array1) {
        //    System.out.println(i);
        //}

        //or another one

        //this annotation is one of the predefined ones and suppresses warning from the compiler
        //must find the appropriate keyword for the case each time, usually provided by ide
        @SuppressWarnings({"UnusedDeclaration"})
        int[] array2 = Arrays.copyOfRange(array, 0, 3);
        //for (int i : array2) {
        //    System.out.println(i);
        //}

        //more methods
        System.out.println("index of element \"2\" in \"array\": " + Arrays.binarySearch(array, 2));
        System.out.println("\"array\" and \"array1\" are equal: " + Arrays.equals(array, array1));
        Arrays.fill(array, 69); // to change elements at specific index or the entire array
        //  for (int i : array) {
        //      System.out.println(i);
        //  }
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        int[] unsortedArray = {5, 4, 1, 6, 7, 2};
        Arrays.sort(unsortedArray); //sort the array
        //  for (int i : unsortedArray) {
        //      System.out.println(i);
        //  }
        System.out.println("\"array\" to string: " + Arrays.toString(array));

        //ternary operator (three values used)
        boolean canDrive = true;    //change this
        String result = "";
        String yes = "He has a license";
        String no = "He doesn't have a license";
        result = canDrive ? yes : no;
        System.out.println(result);
        //would be the same as:
        //if (canDrive)
        //    result = yes;
        //else
        //    result = no;

        // infinite loop
        //for ( ; ; ) {

        // your code goes here
        //}

        //nested classes
        OuterClass outerClassInstance = new OuterClass();
        OuterClass.InnerClass innerClassInstance = outerClassInstance.new InnerClass();
        innerClassInstance.sayHi();
        //inner class instances can only refer to instances of the top level class

        //local class (declared within a block e.g method, for-while loop...)
        //in this example a local class was declared in the constructor of OuterClass with a method that prints "Hello! from a local class"

        new AnonymExample();
        //something to keep in mind when working with inner, local and anonymous classes is to always check where you are, either in the "class body",
        //where of course you can only declare fields or if you are inside a method where you can actually put your code
        //making this note because it's confusing and counterintuitive for some reason

        //from enum, which is like a class
        System.out.println("Federico is " + Friends.FEDERICO.getHeight() + "cm tall.");

        //from record, which is like a class
        Classmate ANDREA = new Classmate("Andrea", "Serra", 18);
        //record automatically generates method for each parameter you define
        System.out.println(ANDREA.age());
        //can also create methods within a record
        ANDREA.greetings();
        System.out.println(ANDREA.getFullName());

        //INTERFACES
        //local class to showcase interface easily
        class Lamborghini implements Car {

            private int speed;

            @Override
            public boolean isFasterThan(Car car) {
                return this.getSpeed() > car.getSpeed();
            }

            @Override
            public int getSpeed() {
                return speed;
            }

            @Override
            public void setSpeed(int speed) {
                this.speed = speed;
            }

            @Override
            public boolean isTooFast() {
                return (speed > speedLimit);
            }
        }

        Lamborghini aventador = new Lamborghini();
        aventador.setSpeed(110);
        Lamborghini urus = new Lamborghini();
        urus.setSpeed(150);
        System.out.println(aventador.isFasterThan(urus));
        System.out.println(urus.isTooFast());

        /*
        When you define a new interface, you are defining a new reference data type.
        You can use interface names anywhere you can use any other data type name.
        If you define a reference variable whose type is an interface,
         any object you assign to it must be an instance of a class that implements the interface.
         */

        /*
        when trying to modify an interface by adding stuff to it, create another interface that extends
        the one you are trying to modify so that the classes that implement the original interface will not break
        OR add default or static methods that are not needed to be implemented in old classes, but will need a body instead so that
        they are ready to be used
         */

        /*
        Empty interfaces can be used as types and to mark classes without requiring any particular method implementations.
        For an example of a useful empty interface, see java.io.Serializable.
         */

        // all fields in an interface are constants which are automatically public static and final.
        // all methods in an interface are automatically public and abstract (they don't have a body)

        /*
        SUMMARY:
        An interface declaration can contain method signatures, default methods, static methods and constant definitions.
        The only methods that have implementations are default and static methods.

        A class that implements an interface must implement all the methods declared in the interface.

        An interface name can be used anywhere a type can be used.
         */

        //LAMBDA EXPRESSIONS

        /*
        A lambda expression consists of the following:
        - a list of parameters within a parentheses, or a parameter alone
        - the arrow token, ->
        - 1) an expression, which is some code that gives a value (any mathematical operation, any function, string concatenation...etc)
          2) OR  a block defined within {} and a return statement if returning a value is needed
         */

        //EXAMPLES OF LAMBDAS

        //1)
        //it's possible to use a lambda as an instance of a functional interface (because interface are reference type, like classes)
        //which is an interface that contains only one abstract method, forEach method is an example
        /*
        "We use forEach to iterate over a collection and perform a certain action on each element.
        The action to be performed is contained in a class that implements the Consumer interface and is passed to forEach as an argument."
         */
        //Since Consumer is a functional interface it's therefore possible to pass a lambda
        ArrayList<Integer> numbers = new ArrayList<>();     //arrayList uses generics which allow to set any type to be in the list itself
        for (int i = 0; i < 5; i++) {
            numbers.add(i);
        }
        numbers.forEach(n -> System.out.print(n));
        //here it's also possible to just use a method reference because print is an existing function like this:
        //numbers.forEach(System.out::print);

        //2)
        /*
        Lambda expressions can be stored in variables if the variable's type is an interface which has only one method.
        The lambda expression should have the same number of parameters and the same return type as that method.
        Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.
         */
        Consumer<Integer> consumer = n -> System.out.println(n);    //can still use method reference here
        numbers.forEach(consumer);  //which has the same result as example 1) but you're storing the expression in a variable

        //EXTRA: all ways to use forEach

        //lambda expression: very good way with concise code
        numbers.forEach(n -> System.out.print(n));
        //method reference: very good but works only with existing methods
        numbers.forEach(System.out::print);
        //passing a consumer object: good but there is no need in this case to store the functionality,
        //                                       maybe if it was going to used by different forEach methods yes then
        Consumer<Integer> c = n -> System.out.println(n);
        numbers.forEach(c);
        //creating anonymous class with Consumer type: very bad, can't access parameters easily and syntax is uselessly long
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print("b");
            }
        });
        //creating a class that implements the interface and passing an instance to consumer: extremely bad, can't access parameters easily and too long
        class UselessClass implements Consumer {
            @Override
            public void accept(Object o) {
                System.out.print("a");
            }
        }
        numbers.forEach(new UselessClass());

        //3)
        //Creating a method to that uses a lambda as a parameter (like forEach).

        /*
        To use a lambda expression in a method, the method should have a parameter with a single-method interface as its type.
        Calling the interface's method will run the lambda expression:
         */

        //in this example a method that takes two integers and performs a mathematical operation between depending on the lambda provided is created

        //firstly a functional interface is needed
        //using annotation is good practise
        //perform method returns int which is the type desired and needs the two numbers to do the operations with as parameters
        @FunctionalInterface
        interface Operation {
            int perform(int a, int b);
        }

        //secondly create the method with the numbers a and b to be added and another parameter with Operation type
        //(the functional interface) and CALL ITS METHOD TO RUN THE LAMBDA which will be created when it is run
        class ConvenienceClass {
            static int performOperation(Operation operation, int a, int b) {
                return operation.perform(a, b);
            }
        }

        //finally run the method with some lambdas
        Operation addition = (a, b) -> a + b;   //can still use method reference here...
        System.out.println("4 + 5 calculated with a method that takes a lambda is " + ConvenienceClass.performOperation(addition, 4, 5));

        //4)
        //lambdas are used a lot to provide functionality to gui components like a button
        JFrame frame = new JFrame("button test");
        frame.setSize(150, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("press me");
        //to add functionality to a button an action listener can be used
        //an action listener is a functional interface
        //the method addActionListener takes an instance of a class that implements the ActionListener interface
        //where we can easily pass a lambda

        //first lets do it with anonymous class
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi from anonymous class listener");
            }
            //remember that if we were to add a method in this anonymous class it would not be possible to use a lambda instead,
            //lambdas can even have a block with a return statement to have complex functionality but they are still a single function, not a class
        });
        button.addActionListener(e -> {
            System.out.println("Hi from lambda listener!");
            System.out.println("It's also a lambda block listener!!!");
        });

        frame.add(button);
        frame.setVisible(true);

        //more practise with functional interfaces and lambdas
        //functional interface that has only 1 method
        interface Customization {
            String customize(String str);
        }

        class Customizer {
            static String customizeString(Customization cus, String str) {
                return cus.customize(str);
            }
        }

        Customization exclamation = str -> str + "!";

        System.out.println(Customizer.customizeString(exclamation, "Hello"));

        //Inheritance

        /*
            Excepting Object, which has no superclass, every class has one and only one direct superclass (single inheritance).
            In the absence of any other explicit superclass, every class is implicitly a subclass of Object.
         */

        /*
        A subclass inherits all the members (fields, methods, and nested classes) from its superclass.
        Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.
         */

        //What You Can Do in a Subclass:

        /*
        The inherited fields can be used directly, just like any other fields.
        You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
        You can declare new fields in the subclass that are not in the superclass.
        The inherited methods can be used directly as they are.
        You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it.
        You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
        You can declare new methods in the subclass that are not in the superclass.
        You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
         */

        /*
        MountainBike is descended from Bicycle and Object.
        Therefore, a MountainBike is a Bicycle and is also an Object, and it can be used wherever Bicycle or Object objects are called for.
        The reverse is not necessarily true: a Bicycle may be a MountainBike, but it isn't necessarily.
         Similarly, an Object may be a Bicycle or a MountainBike, but it isn't necessarily.
         */

        //every class is a subclass of Object
        //while you go down in the hierarchy you find more specialised functionality

        //CASTING
        /*
        Casting shows the use of an object of one type in place of another type, among the objects permitted by inheritance and implementations. For example, if we write

        Object obj = new MountainBike();
        then obj is both an Object and a MountainBike (until such time as obj is assigned another object that is not a MountainBike).
        This is called implicit casting.

        If, on the other hand, we write

        MountainBike myBike = obj;
        we would get a compile-time error because obj is not known to the compiler to be a MountainBike. However, we can tell the compiler that we promise to assign a MountainBike to obj by explicit casting:

        MountainBike myBike = (MountainBike)obj;
        This cast inserts a runtime check that obj is assigned a MountainBike so that the compiler can safely assume that obj is a MountainBike.
        If obj is not a MountainBike at runtime, an exception will be thrown.
         */

        //implicit casting:
        //Object obj = new MountainBike()
        //where it's obvious that obj can be a MountainBike since every class is a child of Object
        //implicit casting is used from super class to subclass in this sense

        //explicit casting:
        //MountainBike bike = (MountainBike) obj;
        //here instead obj could be anything and the compiler throws an exception when trying to assign it to bike
        //we need to make sure the compiler knows obj is a MountainBike by explicitly casting it
        //explicit casting is used from subclass to super class in this sense
        //and it makes a lot of sense because the object must be "castable"
        //you could not cast a String to an int for example cause they are not related in any way

        //keyword instanceof is useful in this matters

        //MULTIPLE INHERITANCE
        //"One significant difference between classes and interfaces is that classes can have fields whereas interfaces cannot"
        //and this is actually why you can extend only a single class while with interface there can be multiple inheritance.
        //suppose that a class could extend multiple classes and these classes have some fields in common, then whose fields
        //would be inherited? Interface don't have this problem therefore an interface can extend infinite interfaces;

        //a class can only extend a single class
        //a class can implement multiple interfaces
        //an interface can extend multiple interfaces

        /*
        The Java programming language supports multiple inheritance of type, which is the ability of a class to implement more than one interface.
        An object can have multiple types: the type of its own class and the types of all the interfaces that the class implements.
        THIS MEANS THAT if a variable is declared to be the type of an interface,
        then its value can reference any object that is instantiated from any class that implements the interface.
         */

        //already covered but good to know again:
        //when creating an object with an interface as type,
        //then its value can reference any object that is instantiated from any class that implements the interface
        //(usually this is worked out by anonymous classes)

        /*
        The ability of a subclass to override a method allows a class to inherit from a superclass whose behavior is "close enough"
        and then to modify behavior as needed.
        The overriding method has the same name, number and type of parameters,
        and return type as the method that it overrides.
        An overriding method can also return a subtype of the type returned by the overridden method.
        This subtype is called a covariant return type.
         */

        //example:
        class Energy {}
        class Protein extends Energy {}

        class Food {
            Energy giveEnergy() {
                return null;
            }
        }

        class Steak extends Food {
            @Override
            Protein giveEnergy() {
                return (Protein) super.giveEnergy();
            }
        }

        //Protein in this case is a covariant return type
        //giveEnergy from Steak class would normally return Energy just like the same method in parent class does
        //but it can also return Protein because it is a

        /*
        If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.

        The distinction between hiding a static method and overriding an instance method has important implications:

        The version of the overridden instance method that gets invoked is the one in the subclass.
        The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.
         */

        //basically a static method can be "hidden" a by a subclass when creating the same static method but
        //what method is run depends on which class it is called from, since it's static

        //example
        class Ex {
            static void greet() {
                System.out.println("hello from super class");
            }
        }
        class Ex1 extends Ex {
            static void greet() {   //methods are identical
                System.out.println("hello from subclass");
            }
        }
        Ex.greet();
        Ex1.greet();

        /*
        Default methods and abstract methods in interfaces are inherited like instance methods.
        However, when the supertypes of a class or interface provide multiple default methods with the same signature,
        the Java compiler follows inheritance rules to resolve the name conflict.
        These rules are driven by the following two principles:
         */

        //default methods in interface can have the same name as instance method in subclasses
        //there the compiler chooses to run to instance method instead of the others
        class Horse {
            public String identifyMyself() {    //THIS METHOD BY GETTING CALLED SAVES THE PROGRAM BECAUSE
                return "I am a horse.";             //THERE CANNOT BE THE SAME DEFAULT METHOD IN A INTERFACE
            }
        }
        interface Flyer {
            default String identifyMyself() {       //METHODS MUST BE DEFAULT IN INTERFACE TO HAVE A BODY
                return "I am able to fly.";
            }
        }
        interface Mythical {
            default String identifyMyself() {       //METHODS MUST BE DEFAULT IN INTERFACE TO HAVE A BODY
                return "I am a mythical creature.";         //ALL THIS LOGIC WOULDN'T MAKE ANY SENSE IN ANOTHER CASE
            }
        }
        class Creature extends Horse implements Flyer, Mythical {
            static void defineMyself() {
                Creature creature = new Creature();
                System.out.println(creature.identifyMyself());  //which one is going to be run??
                //the instance method is preferred over the default interface ones
                //so I am a horse is the output
            }
        }
        Creature.defineMyself();

        //note that multiple identical default methods can't exist in multiple interfaces all implemented by the same class
        //because the compiler can't choose and throws an exception,
        //while if you have an instance method from a super class
        //there are no problems because this is the one that's given priority in any case

        //see how interfaces with default method bring multiple inheritance in java but problems and complication arise
        //while with classes there can be only one extension and therefore no conflicts

        //within a single interface there can't be methods with the same name no matter if they are default, static or instance
        //just like in a class

        interface Animal {
            default public String identifyMyself1() {
                return "I am an animal.";
            }
        }
        interface EggLayer extends Animal {
            @Override
            default String identifyMyself1() {
                return "I am able to lay eggs.";
            }
        }

        class Dragon implements Animal, EggLayer{
            static void defineMyself1() {
                Dragon dragon = new Dragon();
                System.out.println(dragon.identifyMyself1());
            }
        }
        Dragon.defineMyself1();

        //in this case, where an interface extends another
        //and there are 2 methods with the same name,
        //only the one of the extending interface gets called

        //SUMMARY:
        //so if there are methods with the same name within different interfaces and a class
        //(only one class may be extended, while you can implement multiple interfaces)
        //the priority goes:
        //FIRSTLY to the instance method of the class
        //SECONDLY to the default method of the subclass interface
        //if there are multiple interfaces with the same default method compiler throws an exception
        //there can't be multiple classes with the same method because a class can only extend another class and no more

        //POLYMORPHISM is the ability of an object to have multiple states etc bla bla
        //look at the example on the java doc where you have bicycle of different subclass which have their own implementation
        //of a method bla bla

        //HIDING FIELDS
        /*
        Within a class, a field that has the same name as a field in the superclass hides the superclass' field, even if their types are different.
        Within the subclass, the field in the superclass cannot be referenced by its simple name.
        Instead, the field must be accessed through super, which is covered in the next section.
        Generally speaking, we don't recommend hiding fields as it makes code difficult to read.
         */

        //hiding fields is just creating a variable in the subclass with the same of one in the superclass:
        //no matter what the type the subclass variable hides the superclass' one and this practise is just bad

        //SUPER
        //1)super keyword can be used to access superclass members (which are fields, constants, methods... everything belonging to the class)
        //example:

        class SuperClass {
            void printMethod() {
                System.out.println("Printed in Super Class");
            }
        }
        class SubClass extends SuperClass {
            @Override
            void printMethod() {
                super.printMethod();    //super allows us to refer to the superclass method and therefore call it (similar to this keyword under the circumstance of using "super.")
                System.out.println("Printed in SubClass");
            }
        }
        SuperClass xd = new SubClass();
        xd.printMethod();

        //2) super can be used to invoke parent class constructor like a method
        //example:
        class Vehicle {

            int maxSpeed, numOfWheels;
            String name;

            Vehicle(String name, int maxSpeed, int numOfWheels) {
                this.maxSpeed = maxSpeed;
                this.name = name;
                this.numOfWheels = numOfWheels;
                System.out.println("Printed by vehicle constructor");
            }

        }

        class Bike extends Vehicle {

            Bike(String name, int speed, int numOfWheels) {
                super(name, speed, numOfWheels);
                System.out.println("I am a " + name + " with " + numOfWheels + " wheels " + "and my speed is " + maxSpeed);
            }
        }
        new Bike("bike", 30, 2);

        //NOTE:
        //when you extend a class there must be a constructor with the same parameters
        //or more in the subclass that calls super with those parameters!

        int x = 10;
        System.out.println(~x);
        //returns -x-1

        //OBJECT AS A SUPERCLASS
        //objects is the superclass of every java class and has some interesting methods to override

        //1) toString()
        //    this can be overridden to print a text representation of an object
        //    NOTE: TOSTRING() IS WHAT WOULD BE PRINTED IF WE WERE TO PRINT AN OBJECT

        //comparison between non-overridden toString() and overridden toString():
        class Person {
            private String name;
            private String surname;
            private int age;

            Person(String name, String surname, int age) {
                this.age = age;
                this.name = name;
                this.surname = surname;
            }

            //overridden version
            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        Person p = new Person("Mark", "Martinez", 25);
        System.out.println(p);  //calling the method is not necessary, just printing the objects is enough

        //2) the other good method from Object getClass()
        //    which returns a Class objects from which we
        //    can call more methods to get information about the original object
        System.out.println(p.getClass().getName());

        //the other methods from Object are not that good to override
        //there are 5 methods that allows to work with different threads but they are not going to be covered yet

        //WHEN A CLASS IS FINAL IT CAN'T BE SUBCLASSES
        //WHEN A METHOD IS FINAL IT CAN'T BE OVERRIDDEN

        /*
        Except for the Object class, a class has exactly one direct superclass. A class inherits fields and methods from all its superclasses, whether direct or indirect. A subclass can override methods that it inherits, or it can hide fields or methods that it inherits. (Note that hiding fields is generally bad programming practice.)

        The table in Overriding and Hiding Methods section shows the effect of declaring a method with the same signature as a method in the superclass.

        The Object class is the top of the class hierarchy. All classes are descendants from this class and inherit methods from it. Useful methods inherited from Object include toString(), equals(), clone(), and getClass().

        You can prevent a class from being subclassed by using the final keyword in the class's declaration. Similarly, you can prevent a method from being overridden by subclasses by declaring it as a final method.

        An abstract class can only be subclassed; it cannot be instantiated. An abstract class can contain abstract methods—methods that are declared but not implemented. Subclasses then provide the implementations for the abstract methods.
         */

        //NUMBERS AND STRINGS
        //for each of the primitive data type there is a corresponding wrapper class
        //talking about numbers all these classes are subclasses of the abstract class Number
        //from which they inherit useful methods
        //sometimes you can't just use the primitive data type and you need an object
        //examples are pointless in this section cause they are well known

        //INTERESTING:
        //Subclasses of Number are also BigDecimal and BigInteger which are for high-precision calculation
        //and AtomicInteger and AtomicLong which are for multithreading

        //there are methods to format your printed output, like format or printf
        //those can by called by printStream objects (like System.out) and work like in C

        //Math class only has static methods and allow you to perform more complex mathematical operations
        System.out.println(Math.cos(0));
        //Math.random() returns a random number between 0 and 9 (0 inclusive and not 9)

        //INTERESTING:
        //in each of the wrapper class there are constants that contain the max and min value that the data type can hold
        //example:
        System.out.println(Long.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        //wrapper class for char is Character
        Character character = 'a';

        //strange way for creating a string (without literal)
        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        String helloString = new String(helloArray);
        System.out.println(helloString);

        //palindrome showcase length() method
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();

        //there are many methods to manipulate strings in String class
        //strings character work like arrays and in these methods the starting index is always included
        //while the finishing index is actually the one before
        class StringFormatter {
            static String getExtension(String str) {
                int dot = str.lastIndexOf('.');     //gets the index of the last . that appears in the String
                return str.substring(dot);     //returns a substring that starts with the index of the last dot up to the end of the string
                //in this case the ending index is not need but in any case it would have been the length of the string
                //because it's actually the index before
                //example "ciao" indexes are 0 1 2 3 so length would give 4 but since the function uses the index before
                //its actually from
            }
        }
        System.out.println(StringFormatter.getExtension("index.html"));
        //there are many more methods like substring(), replace(), indexOf(), lastIndexOf(), trim(), contains()....

        //there are also many ways to compare strings like startsWith(), endsWith(), compareTo()...

        //THE STRINGBUILDER CLASS
        /*
        StringBuilder objects are like String objects, except that they can be modified.
        Internally, these objects are treated like variable-length arrays that contain a sequence of characters.
        At any point, the length and content of the sequence can be changed through method invocations.

        Strings should always be used unless string builders offer an advantage in terms of simpler code
        (see the sample program at the end of this section) or better performance.
        For example, if you need to concatenate a large number of strings, appending to a StringBuilder object is more efficient.

        //Length and Capacity
        The StringBuilder class, like the String class, has a length() method that returns the length of the character sequence in the builder.

        Unlike strings, every string builder also has a capacity, the number of character spaces that have been allocated.
        The capacity, which is returned by the capacity() method,
        is always greater than or equal to the length (usually greater than)
        and will automatically expand as necessary to accommodate additions to the string builder.
         */

        //The StringBuilder class allows to modify its items unlike the String class (Strings are immutable in java)
        //these objects have a length just like a normal string would, but also a capacity (is returned from capacity()) which is the maximum
        //amount of characters that a StringBuilder can hold which increases automatically (but there is still ensureCapacity(int minCapacity)
        //which makes sure the capacity is larger than the specified value.
        //String class it to be preferred unless there is the need to do complicate operations on the strings
        //initial capacity of a StringBuilder without specification is 16

        //examples:
        // creates empty builder, capacity 16
        StringBuilder sb = new StringBuilder();
        // adds 9 character string at beginning
        sb.append("Greetings");
        System.out.println(sb);

        //can also create StringBuilder with a string argument
        StringBuilder sb1 = new StringBuilder("Hello World");

        /*
        The principal methods in StringBuilder that are not available in String are append() and insert()
        both of them are overloaded so that they can accept any data type as argument
        1) append() adds its argument at the end of the StringBuilder object
        2) insert() adds it at a specified position
         */

        //examples
        sb1.append("!");
        System.out.println(sb1);
        sb1.insert(6, "Davide and ");   //offset indicates the index before which the second parameter needs to be inserted
        System.out.println(sb1);

        //there are other methods too
        //reverse is powerful
        sb1.reverse();
        System.out.println(sb1);

        StringBuilder palindromeReversed = new StringBuilder(palindrome);
        System.out.println(palindromeReversed.reverse());       //xd

        //IMPORTANT:
        //we can print StringBuilder objects like Strings because the toString() method
        //is called implicitly like in any print() method with any data type (also your classes which is why you override toString())
        //StringBuffer class is the same as StringBuilder but it's thread safe so will be covered in the future

        //Overall the StringBuilder class is a good and useful class worth investing your time in

        //example of AutoBoxing:
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li.add(i);
        //even if li wants Integer as data type the code compiles if you are adding ints
        //autoboxing: the compiler converts the primitive data type to the Wrapper class Type automatically
        //reversed process is called unBoxing
        //remember all the Wrapper classes are just the same primitive type with the first letter capital
        //except for char which becomes Character

        //Generics

        //In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods.

        //to use generics in a class just add <> brackets and put the "type parameters" usually T

        //there is a naming convention for type parameters tho:

        /*
        Type Parameter Naming Conventions
        By convention, type parameter names are single, uppercase letters.
        This stands in sharp contrast to the variable naming conventions that you already know about, and with good reason:
        Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name.

        The most commonly used type parameter names are:

        E - Element (used extensively by the Java Collections Framework)
        K - Key
        N - Number
        T - Type
        V - Value
        S,U,V etc. - 2nd, 3rd, 4th types
        You'll see these names used throughout the Java SE API and the rest of this lesson.
         */

        //example time:
        class Box {
            private Object object;

            public void set(Object object) { this.object = object; }
            public Object get() { return object; }
        }

        //but there are problems with this approach:
        /*
        There is no way to verify, at compile time, how the class is used.
        One part of the code may place an Integer in the box and expect to get Integers out of it,
        while another part of the code may mistakenly pass in a String, resulting in a runtime error.
         */

        class Box1<T> {
            // T stands for "Type"
            private T t;

            public void set(T t) { this.t = t; }
            public T get() { return t; }
        }

        //generics version is much better
        //because it prevents runtime error from occurring

        //now create an object from that class
        Box1<Integer> integerBox1 = new Box1<>();
        //in addition to the normal procedure we need to put the type argument (in this case Integer)
        //within the brackets in declaration but not in instantiation, because we can just leave "the diamond"
        //(which is this: <>)

        //can also work with multiple parameters
        interface Pair<K, V> {
            K getKey();
            V getValue();
        }

        class OrderedPair<K, V> implements Pair<K, V> {

            private K key;
            private V value;

            public OrderedPair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public K getKey()	{ return key; }
            @Override
            public V getValue() { return value; }
        }

        OrderedPair<String, Integer> pair = new OrderedPair<>("davide", 18);    //thx to autoboxing the 18 automatically turns to Integer

        //there can be issues when working with a raw type:
        Box1 rawBox = new Box1<>();
        //rawBox has no type parameters and this is a thing because of compatibility with legacy code
        //need to be aware of what you are doing when working with this things

        //can also use type parameters in methods just put the <> brackets before the return type

        //bounded type parameters restrict the number of type argument that can be passed
        //example:
        class Inspection {
            static <U extends Number> void inspect(U u) {
                System.out.println(u.getClass().getName());     //can only pass a subclass of Number now, not any class
            }
        }
        Inspection.inspect(13); //still thanking autoboxing for converting 13 to an Integer
        //Inspection.inspect("hello");      //wouldn't work

        //there can also be multiple bounds within a parameter but only one of them can be a class and it must be put in the first position

        //generics therefore are to be used when your code needs to be generic and therefore accept any data type as input and work out\

        //a note about inheritance, types and generics
        //as we know everything is a subclass of object so:
        //Box<Number> and Box<Integer> are subclasses of Object
        //the same works for Integer being a subclass of Number
        //but Box<Integer> is NOT a subclass of Box<Number>
        //so if you had a method like:

        //public void boxTest(Box<Number> n) { /* ... */ }
        //you couldn't pass a Box<Integer> as parameter

        //this means that if you want to create subclasses you must not change the Generics type parameter and everything works fine
    }
}
