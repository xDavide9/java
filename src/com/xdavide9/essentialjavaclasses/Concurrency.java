package com.xdavide9.essentialjavaclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrency {

    public Concurrency() throws InterruptedException{
        //SOME CONTEXT AND DEFINITIONS
        //Software that can do multiple things at once is called concurrent software
        //Looking at the java.util.concurrent packages

        //there are two basic units in concurrent programing: Processes and Thread
        //and a computer normally has many of those active even in system with only one core
        //The ability to share processing time within a single core is an OS feature called
        //time slicing

        //DEF
        //A process has a self-contained execution environment, a set of basic run-time resources
        //and its own memory space.

        //Processes are often seen as synonymous with programs or applications, even tho
        //that is not exactly correct, because what is seen by the user as a program might be
        //the result of different cooperating processes.
        //Communication between processes is facilitated by Inter Process Communication (IPC)
        //resources, such as pipes and sockets.
        //Usually the Java virtual machine runs as a single process.
        //but a java application can create multiple processes thanks to a ProcessBuilder objects
        //which is not covered tho

        //DEF
        //Threads are sometimes called lightweight processes. Both a thread and a process create an execution
        //environment but creating a thread requires less resources.
        //Threads exist within a process, every process has at least one. Threads share the process' resources,
        //which makes for an efficient but potentially problematic communication.
        //Every java application has at least one thread, or many if you consider what happens in the background
        //but from the programmer point of view you start with only one thread which is the main thread.
        //https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html

        //SUMMARY of this important first part:

        //A process is a set of instruction (code) that is being executed by the computer
        //It has its own memory space and generally consumes a lot of resources (depends on the process itself tho)
        //Any application is the fruit of at least one process (multiple process can cooperate for a single application
        //through IPC, Inter Process Communication, recourses like pipes or sockets)
        //A process is run by one or multiple threads which reside within the process and share its resources
        //A thread itself is a basic unit of CPU utilization still within processes and therefore often
        //referred to as lightweight process
        //In Java, the virtual machine usually runs as a single process, and you start with only one thread
        //(from the programmer point of view because there are multiple threads working the background)
        //which is the main thread, It is possible to create other processes through a ProcessBuilder object
        //but that requires more resources than creating a Thread object

        //THREADS (in code)
        //there are two ways to create a thread object which is associated with a thread in java:
        //-Passing a runnable object in Thread constructor
        //-Subclass Thread

        //the first approach is generally better cause you don't have dependencies from the Thread class
        //example:


        class ThreadRunnableDemo implements Runnable{

            Thread thread;

            void startThreadDemo() {
                thread = new Thread(new ThreadRunnableDemo());
                thread.start();
                //starts the thread, be careful not to confuse with run
                //(which does run what's inside the run method but doesn't do it from the new thread)

            }

            @Override
            public void run() {
                //this method has the code which is going to be run by the thread
                System.out.println("Hello from " + Thread.currentThread());
            }
        }

        ThreadRunnableDemo demo = new ThreadRunnableDemo();
        demo.startThreadDemo();
        demo.thread.join(); //down below
        demo.thread.interrupt();
        System.out.println("Successfully interrupted thread");

        //PAUSING WITH SLEEP
        //Thread.sleep() causes current thread to sleep for a specified amount of milliseconds
        //example:

        //JOIN
        //t.join() interrupts the execution of the current thread until t is interrupted

        /*
        class ThreadSleepDemo implements Runnable{

        Thread thread;

        void startSleepDemo() {

        //counting up to 10 with 1 second interval
        //showcased with main thread
        //an interruptedException is thrown when the sleeping thread is interrupted

        thread = new Thread(new ThreadSleepDemo());
        thread.start();
        }

        @Override
        public void run() {
        for (int i = 1; i <= 10 ; i++) {
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "is counting: " + i);
        }
        }
        }

        ThreadSleepDemo demo1 = new ThreadSleepDemo();
        demo1.startSleepDemo();
        demo1.thread.join();
        demo1.thread.interrupt();
        System.out.println("Successfully interrupted thread");
        */

        //note about exceptions:
        //adding the throws keyword followed by an Exception type to a method declaration
        //tells the compiler that that method throws that exception
        //this exception should be resolved somewhere in the call stack unless it goes up to the main method
        //cause that is at the top of the call stack

        //-------------------
        //SYNCHRONIZATION (Introduction)
        //threads communicate by sharing access to fields and references and this is efficient
        //but makes to kind of errors possible: thread interference and memory consistency errors
        //To prevent this from happening there is synchronization
        //Synchronization on its hand can cause thread contention
        //which is when different threads try to access the same resource at the same time
        //forms of thread contention are starvation and livelock

        //THREAD INTERFERENCE
        //happens when different threads are trying to access the same resource at the same time
        //example:
        class Counter {
            private int c = 0;

            public void increment() {
                c++;
            }

            public void decrement() {
                c--;
            }

            @Override
            public String toString() {
                return String.valueOf(c);
            }
        }

        /*
        Counter counter = new Counter();

        class CounterDemoA implements Runnable{
        Thread A;

        void startDemo() {
            A = new Thread(new CounterDemoA());
            A.start();
        }

        @Override
        public void run() {
            counter.increment();
            System.out.println(Thread.currentThread() + ": " + counter);
        }
        }

        class CounterDemoB implements Runnable{
        Thread B;

        void startDemo() {
            B = new Thread(new CounterDemoB());
            B.start();
        }

        @Override
        public void run() {
            counter.decrement();
            System.out.println(Thread.currentThread() + ": " + counter);
        }
        }

        CounterDemoA demoA = new CounterDemoA();
        CounterDemoB demoB = new CounterDemoB();
        demoA.startDemo();
        demoB.startDemo();
        demoA.A.interrupt();
        demoB.B.interrupt();
        */
        //assume that one thread is going to run increment() and another one is going to run decrement() simultaneously
        //the result is unpredictable, there might even be no error
        //because they are unpredictable, thread interference bugs are difficult to fix
        //(indeed why is the result of counter 0 in both cases? need to fix this)

        //MEMORY CONSISTENCY ERRORS
        //causes of these are complex
        //they happen when different threads have different views of the same data
        //example:

        //int counter = 0;
        //assume this field is share among 2 threads: A and B
        //now A increments the value with
        //counter++
        //and B prints the value:
        //System.out.println(counter);
        //you would assume the value is going to be 1 but since A and B
        //are different threads the result might well be 0
        //that's because B doesn't know about the changes made by A

        //to fix this a happens-before relationship between the threads
        //must be established (making sure memory writes of one thread
        //are visible to the other)
        //to create this happens-before relationship there are many ways:
        //one of them is synchronization but there is also stuff already covered like
        //Thread.start and Thread.join

        //SYNCHRONIZED METHODS
        //there are also synchronized statement but are not covered for now
        //to make a method synchronized add the synchronized keyword to its declaration
        class SynchronizedCounter {
            private int c = 0;

            public synchronized void increment() {
                c++;
            }

            public synchronized void decrement() {
                c--;
            }

            public synchronized int value() {
                return c;
            }
        }
        //Synchronization has two effects in this case:
        //-it's not possible for different threads to interleave when calling synchronized methods
        //because when one thread is running one of these methods the others just stop and wait for it to finish
        //-when a synchronized method exits it establishes a happens-before relationship with any
        //subsequent invocation of the method for the same object which makes sure that
        //all the threads see the changes made by other threads

        //notes:
        //constructor can't be synchronized cause it makes no sense
        //final fields can be safely read even from un-synchronized methods cause their value cannot change

        //example:
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        class SynchronizedCounterDemoA implements Runnable{
            Thread A;

            void startDemo() {
                A = new Thread(new SynchronizedCounterDemoA());
                A.start();
            }

            @Override
            public void run() {
                synchronizedCounter.increment();
                System.out.println(Thread.currentThread() + ": " + synchronizedCounter.value());
            }
        }

        class SynchronizedCounterDemoB implements Runnable{
            Thread B;

            void startDemo() {
                B = new Thread(new SynchronizedCounterDemoB());
                B.start();
            }

            @Override
            public void run() {
                synchronizedCounter.decrement();
                System.out.println(Thread.currentThread() + ": " + synchronizedCounter.value());
            }
        }

        SynchronizedCounterDemoA demoA1 = new SynchronizedCounterDemoA();
        SynchronizedCounterDemoB demoB1 = new SynchronizedCounterDemoB();
        demoA1.startDemo();
        demoB1.startDemo();
        demoA1.A.join();
        demoB1.B.join();
        demoA1.A.interrupt();
        demoB1.B.interrupt();

        //INTRINSIC LOCKS AND SYNCHRONIZATION
        //Synchronization is built around an internal entity known as the intrinsic lock or monitor lock.
        //every object has one and when a thread needs to perform operation with that object
        //it acquires its intrinsic lock and when it's done with that object it releases the lock.
        //in that time the thread owns that lock and no other thread can own it at the same time
        //When a thread releases a lock, a happens-before relationship is established between that action
        //and any subsequent action on that same lock
        //in synchronized methods the lock is acquired automatically but that's not the case with synchronized statements

        //SYNCHRONIZED STATEMENTS
        //in order to create a synchronized statement the object that provides the lock must be specified
        //example:
        class SynchronizedStatementsEx {
            String lastname;
            int nameCount;
            List<String> nameList = new ArrayList<>();

            public void addName(String name) {
                synchronized (this) {
                    lastname = name;
                    nameCount++;
                }
                nameList.add(name);
            }
            //in this example only the code within the synchronized block is synchronized
            //with the lock provided by this
            //last line of code is not synchronized removing the need of creating a separate method just for that
        }

        //Synchronization of course damages concurrency so there is no reason to synchronize unnecessary stuff
        //example:
        //assume there are two fields that never interact with each other.
        //all updates to them must be synchronized
        //but there is no need to prevent updates of one interleaving with updates on the other
        //therefore it's possible to use synchronized statements to use different locks for each field
        //(instead of creating synchronized methods which would use the same lock)

        class DifferentLocksEx {
            private long c1 = 0;
            private long c2 = 0;
            private Object lock1 = new Object();
            private Object lock2 = new Object();

            public void increaseC1() {
                synchronized(lock1) {
                    c1++;
                }
            }

            public void increaseC2() {
                synchronized(lock2) {
                    c2++;
                }
            }
            //in this example thanks to the use of synchronized statements
            //two different locks were provided for each field
            //the result is that different threads must wait for one another when performing operation on one field
            //but can interleave operations of the two objects (because we assume they never interact with each other
            //otherwise we would probably get thread interference errors)

            //this lock concept is really important because it's basically how synchronization works
            //depending on it threads will wait for each other or not

            //THE LOCK again:
            //Every object has an intrinsic lock and when a threads performs operation on the object
            //it must first acquire the intrinsic lock and then when it's done doing stuff with the object
            //release the lock
            //During this time the thread owns the lock meaning that no other thread can do stuff
            //with the object (basically the core concept of synchronization, stopping a thread when another one
            //is performing stuff with the same object)
            //When using synchronized methods the lock for the objects is acquired automatically and is shared
            //among all the synchronized methods
            //When using synchronized statements the lock for the objects must be specified
            //in a synchronized block
            //synchronized([LOCK]) {
            //  ...
            //}
            //depending on the lock the threads action will be modified
            //it's possible to provide different locks for different methods and arrange the code
            //for the best depending on the situation
        }

        //-----------------------------------
        //ATOMIC ACCESS
        //in programming, an atomic action is one that cannot be stop in the middle, and
        //happens all at once or doesn't happen at all
        //for example an increment is not an atomic action (because the JVM takes different steps
        //to perform the operation: retrieve the value, increment it, and storing the new value)
        //some atomic actions are:
        //-reads and writes for reference variables (object of a class) and primitive values (except for long and double)
        //-read and writes for all variables declared volatile (also long and double)

        //therefore with Atomic Action there is no need to worry about thread interference but
        //synchronization may still be used to prevent memory consistency errors
        //using volatile variables reduces the risk of memory consistency errors
        //because it establishes a happens-before relationship with the subsequent actions
        //generally using atomic variable is more efficient than using synchronized code
        //but requires more care by the programmer to avoid memory consistency errors
        //working with atomic methods that do not rely on synchronization will be covered later
        //in the java.util.concurrent package

        //------------------
        //LIVENESS
        //the ability of a concurrent application to execute in a timely manner is called liveness
        //the most basic kind of liveness problem is a deadlock
        //there are also starvation and livelock

        //DEADLOCK
        //happens when different threads are blocked forever, waiting for each other

        //STARVATION
        //happens when a thread is continuously running a method that for example takes
        //a long time to return
        //other threads are starved by that thread and can't access the resource because of synchronization

        //LIVELOCK
        //a thread often acts in response to another thread, but if that other thread is acting in response of another thread
        //livelock might occur (basically they are stuck communicating with each other)
        //in this case threads are not blocked forever as in a deadlock

        //GUARDED BLOCKS
        //are the most common way to coordinate action among different threads
        //such a block begins with a condition that must be true before the block can procede
        //to do so you could think of this simple approach
        class GuardedJoyDemo {
            boolean joy;

            public void guardedJoy() {
                while(!joy) {}
                System.out.println("joy has been achieved!");
                //But this approach is wrong cause the loop is running all the time
                //waiting for the other thread to change the value of joy so that the method can return
                //Waste of resources
            }
        }
        //to make it more efficient it's possible to use wait() from Object class
        //which can be called from anywhere because every class is a child of Object

        class EfficientGuardedJoyDemo {
            boolean joy;

            public synchronized void guardedJoy() {
                while(!joy) {
                    try {
                        wait();
                        //the invocation of wait won't return until another thread notifies
                        //a special event occurred (not necessarily the even this thread is waiting for tho)
                        //wait() is put in a synchronized statement to make sure we have the lock from where we are calling it
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("joy and efficiency achieved");
            }
        }

        //at this point the thread is just waiting for the notification that
        //a special event occurred (joy changed to true in this case)

        /*
        public synchronized notifyJoy() {
            joy = true;
            notifyAll();    //this notifies all the threads and is the most commonly used
        }
         */

        //A REAL EXAMPLE:

        /*
        Let's use guarded blocks to create a Producer-Consumer application.
        This kind of application shares data between two threads: the producer, that creates the data, and the consumer,
        that does something with it. The two threads communicate using a shared object.
        Coordination is essential: the consumer thread must not attempt to retrieve the data before the producer thread has delivered it,
        and the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data.
         */

        //In this example, the data is a series of text messages, which are shared through an object of type Drop:


        class Drop {
            // Message sent from producer
            // to consumer.
            private String message;
            // True if consumer should wait
            // for producer to send message,
            // false if producer should wait for
            // consumer to retrieve message.
            private boolean empty = true;

            public synchronized String take() {
                // Wait until message is
                // available.
                while (empty) {
                    try {
                        wait();
                    } catch (InterruptedException e) {}
                }
                // Toggle status.
                empty = true;
                // Notify producer that
                // status has changed.
                notifyAll();
                return message;
            }

            public synchronized void put(String message) {
                // Wait until message has
                // been retrieved.
                while (!empty) {
                    try {
                        wait();
                    } catch (InterruptedException e) {}
                }
                // Toggle status.
                empty = false;
                // Store message.
                this.message = message;
                // Notify consumer that status
                // has changed.
                notifyAll();
            }
        }


        //The producer thread, defined in Producer, sends a series of familiar messages.
        //The string "DONE" indicates that all messages have been sent.
        //To simulate the unpredictable nature of real-world applications, the producer thread pauses for random intervals between messages.


        class Producer implements Runnable {
            private Drop drop;

            public Producer(Drop drop) {
                this.drop = drop;
            }

            public void run() {
                String importantInfo[] = {
                        "Mares eat oats",
                        "Does eat oats",
                        "Little lambs eat ivy",
                        "A kid will eat ivy too"
                };
                Random random = new Random();

                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    drop.put(importantInfo[i]);
                    try {
                        Thread.sleep(random.nextInt(5000));
                    } catch (InterruptedException e) {}
                }
                drop.put("DONE");
            }
        }


        //The consumer thread, defined in Consumer, simply retrieves the messages and prints them out,
        //until it retrieves the "DONE" string. This thread also pauses for random intervals.


        class Consumer implements Runnable {
            private Drop drop;

            public Consumer(Drop drop) {
                this.drop = drop;
            }

            public void run() {
                Random random = new Random();
                for (String message = drop.take();
                     ! message.equals("DONE");
                     message = drop.take()) {
                    System.out.format("MESSAGE RECEIVED: %s%n", message);
                    try {
                        Thread.sleep(random.nextInt(5000));
                    } catch (InterruptedException e) {}
                }
            }
        }

        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();

        //my example which is similar to the one provided by java tutorials above
        //a message class which holds a condition that must be true in order to print a message
        //as long as the condition is false code from Thread1 calling printMessage()
        //won't execute waiting for Thread2 to change it and then notify
        //(changing the condition to true means exiting the for loop while calling notify all makes the threads that are waiting stop waiting)

        class Message {
            //if true print the message
            //if false wait
            boolean condition = false;

            Random random = new Random();

            synchronized void printMessage() {
                while (!condition) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("hello world");
            }

            synchronized void notifyCondition() {
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
                condition = true;
            }
        }

        class Thread1 implements Runnable {

            Message message;

            Thread1(Message message) {
                this.message = message;
            }

            @Override
            public void run() {
                message.printMessage();
            }
        }

        class Thread2 implements Runnable {

            Message message;

            Thread2(Message message) {
                this.message = message;
            }

            @Override
            public void run() {
                message.notifyCondition();
            }
        }

        Message message = new Message();
        new Thread(new Thread1(message)).start();
        new Thread(new Thread2(message)).start();

        //guarded blocks are a really op implementation of threads

        //IMMUTABLE OBJECTS
        //an object is immutable if its state cannot change after it has been created
        //they are particularly useful in concurrent application since they cannot be corrupted by thread interference for example
        //programmers are usually reluctant about using them tho but they are good in reality

        //example:
        //assume there are two threads
        //one sets a field to a specific value and then tries to print it
        //but before that value is printed it is changed by another thread
        //the value that is going to be printed is going to be different
        //than what originally was here
        //with an immutable object, that would never be a problem

        //example class without immutable objects:
        class SynchronizedRGB {

            // Values must be between 0 and 255.
            private int red;
            private int green;
            private int blue;
            private String name;

            private void check(int red, int green, int blue) {
                if (red < 0 || red > 255
                        || green < 0 || green > 255
                        || blue < 0 || blue > 255) {
                    throw new IllegalArgumentException();
                }
            }

            public SynchronizedRGB(int red, int green, int blue, String name) {
                check(red, green, blue);
                this.red = red;
                this.green = green;
                this.blue = blue;
                this.name = name;
            }

            public void set(int red, int green, int blue, String name) {
                check(red, green, blue);
                synchronized (this) {
                    this.red = red;
                    this.green = green;
                    this.blue = blue;
                    this.name = name;
                }
            }
        }

        //in order to make the class immutable:
        //-should not contain setter methods
        //-make all fields private and final
        //-don't allow subclasses to override methods (can be done by declaring the class final)
        //-don't allow reference to mutable objects to be changed

        //in this specific class
        //-there are two setter methods, the set one must be erased completely because it makes no sense
        //in an immutable context, and the other, invert should be changed by creating a new object
        //-fields should also be final, not only private
        //-the class should be final
        //-only one reference to an object that is immutable so it's ok on this side

        //now the updated version:

        final class ImmutableRGB {

            // Values must be between 0 and 255.
            final private int red;
            final private int green;
            final private int blue;
            final private String name;

            private void check(int red,
                               int green,
                               int blue) {
                if (red < 0 || red > 255
                        || green < 0 || green > 255
                        || blue < 0 || blue > 255) {
                    throw new IllegalArgumentException();
                }
            }

            public ImmutableRGB(int red,
                                int green,
                                int blue,
                                String name) {
                check(red, green, blue);
                this.red = red;
                this.green = green;
                this.blue = blue;
                this.name = name;
            }


            public int getRGB() {
                return ((red << 16) | (green << 8) | blue);
            }

            public String getName() {
                return name;
            }

            public ImmutableRGB invert() {
                return new ImmutableRGB(255 - red,
                        255 - green,
                        255 - blue,
                        "Inverse of " + name);
            }
        }

        //--------------------
        //HIGH LEVEL CONCURRENCY OBJECT (for advanced tasks)
        //-Lock objects, better than implicit locks because they can back out if they can't acquire a lock
        //-Executors, allow to separate thread management from the rest of the application
        //-Concurrent collections, that avoid using synchronization
        //-Atomic variables

        //classes for this are provided by the java.util.concurrent.atomic package
        //and support atomic operations on single variables.
        //all classes have get() and set() methods that work like reads and writes on volatile variables.
        //every invocation of set() establishes a happens-before relationship with each invocation of get()
        //example:

        //this is the original counter class previously covered
        class Counter1 {
            private int c = 0;

            public void increment() {
                c++;
            }

            public void decrement() {
                c--;
            }

            public int value() {
                return c;
            }
        }

        //in order to prevent thread interference from happening
        //it was changed in a synchronized version:

        class SynchronizedCounter1 {
            private int c = 0;

            public synchronized void increment() {
                c++;
            }

            public synchronized void decrement() {
                c--;
            }

            public synchronized int value() {
                return c;
            }

        }

        //which is fine since it's a small class in small application
        //but in a bigger project it would be better like in an atomic version:

        class AtomicCounter1 {
            private AtomicInteger c = new AtomicInteger(0);

            public void increment() {
                c.incrementAndGet();
            }

            public void decrement() {
                c.decrementAndGet();
            }

            public int value() {
                return c.get();
            }

        }

        //in the end concurrent random numbers for
        //application that want to use random with multiple threads
        //just invoke
        int r = ThreadLocalRandom.current().nextInt();
        System.out.println(r);

    }
}
