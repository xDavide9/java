package com.xdavide9.javacollections;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class QueueDequeMap {

    QueueDequeMap() {
        //THE QUEUE INTERFACE
        System.out.println("THE QUEUE INTERFACE");
        System.out.println("nothing to showcase with print statements really");
        //a queue si a collection for holding elements prior to processing and this is it how it looks like
        /*
        public interface Queue<E> extends Collection<E> {
            E element();
            boolean offer(E e);
            E peek();
            E poll();
            E remove();
        }
         */
        //notice that these extra methods can be put in pairs
        //Collection.add() and boolean offer(E e)
        //E remove() and E poll()
        //E element() and E peek()
        //basically one of them throws an exception and the other returns a special value when the operation fails
        //add() throws an exception while offer returns false
        //remove() throws an exception while poll() returns null
        //element() throws an exception while peek() returns null

        //now every Queue implementation can provide its own rules depending on how to manage the order of elements
        //but generally they are in FIFO (first in first out) way meaning that new elements are added at the tail of the queue
        //the remove() or poll() both return and remove an element from the head of the queue
        //while element() or peek() just return the element from the head of the queue

        //Blocking queue methods, used in concurrent programming, which are methods that wait for for elements to appear or space to available
        //are defined in BlockingQueue which extends Queue

        //here is a program that illustrates the use of a queue to store elements before processing
        //it is not the best example cause this could have been done more naturally without a queue
        //but it still shows how a queue is good to store elements before processing (performing operation on them)
        //running on its own thread not to stop the main thread

        class Holder implements Runnable{
            void startCounting() {
                int time = 10;
                Queue<Integer> queue = new LinkedList<>();

                for (int i = time; i >= 0; i--)
                    queue.add(i);   //store the elements in the queue

                while (!queue.isEmpty()) {  //checking that the queue is not empty
                    System.out.println(queue.remove()); //printing each element
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            Holder() {
                new Thread(this).start();
            }

            @Override
            public void run() {
                startCounting();
            }
        }
        //new Holder();

        //THE DEQUE INTERFACE
        System.out.println("\nTHE DEQUE INTERFACE");
        System.out.println("nothing to showcase with print statements really");
        //a deque is basically a double ended queue, meaning that it allows insertion and removal of elements both at the beginning and end
        /*
        Type of Operation	        First Element (Beginning of the Deque instance)	        Last Element (End of the Deque instance)

        Insert	                        addFirst(e)                                                             addLast(e)
                                            offerFirst(e)	                                                        offerLast(e)

        Remove	                        removeFirst()                                                         removeLast()
                                            pollFirst()	                                                            pollLast()

        Examine	                    getFirst                                                                  getLast()
                                            peekFirst()	                                                            peekLast()

         */
        //this table just shows how you just add First and Last to the names of the methods provided by Queue

        //THE MAP INTERFACE
        System.out.println("\nTHE MAP INTERFACE");
        //a map is an object that maps keys to values.
        //a map cannot contain duplicate keys and each key can map to at most one value.
        //there are basic methods like put, get, remove, containsKey, containsValue, size and empty
        //but also bulk operations
        //there are three implementation in the java language: HashMap, TreeMap, and LinkedMap which are the same as the ones in Set

        //looking to how it is possible to use aggregate operation to map some values based on a different key
        //modelling of course real life situations which is often an asked task in object oriented programming

        //defining a data type and properties to classify on

        enum Likes {
            MATH, COMPUTERS, FINANCE
        }

        class Person {
            String name;
            int age;
            int salary;
            Likes likes;

            Person(String name, int age, int salary, Likes likes) {
                this.name = name;
                this.likes = likes;
                this.age = age;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", salary=" + salary +
                        ", likes=" + likes +
                        '}';
            }

        }

        //now create a list of people
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tonya", 19, 80_000, Likes.MATH));
        people.add(new Person("Camilla", 22, 45_000, Likes.COMPUTERS));
        people.add(new Person("Warren", 89, 100_000, Likes.FINANCE));
        people.add(new Person("Michael", 15, 0, Likes.MATH));
        System.out.println(people);

        //now map them using aggregate operations

        //mapping on age
        Map<Boolean, List<Person>> byUnderAge = people.stream().collect(Collectors.partitioningBy(person -> person.age <= 18));
        //System.out.println(byUnderAge);
        //in this example a Boolean value (key) is associated to each person of the people List with collect.(Collectors.partitioningBy(Predicate predicate))

        //mapping on Likes
        Map<Likes, List<Person>> byLikes = people.stream().collect(Collectors.groupingBy(person -> person.likes));
        //System.out.println(byLikes);
        //in this example they are grouped thanks to Collectors.groupingBy(Function function)

        //mapping on salary
        Map<Boolean, List<Person>> bySixFigure = people.stream().collect(Collectors.partitioningBy(person -> person.salary >= 100_000));
        //System.out.println(bySixFigure);

        //NOTE:
        //note that as the value a list is always used because remember that a key can only have a single value
        //so if this value would have been a single person and not a list of people only the last occurrence of a person verifying the condition needed to be assigned
        //to the key would actually be assigned (the other people would get overridden)

        //now it is really easy to retrieve information from our maps
        //print underage people:
        System.out.println("UnderAge: " + byUnderAge.get(true));
        //print overage people:
        System.out.println("OverAge: " + byUnderAge.get(false));
        //print by likes
        System.out.println("Interested in Math: " + byLikes.get(Likes.MATH));
        //and so on...

        //there are of course other ways to create maps like manually putting the values associated with the keys
        Map<Integer, String> ex = new HashMap<>();
        ex.put(1, "a"); //value a is assigned to key 1
        ex.put(2, "b"); //value b is assigned to key 2
        ex.put(3, "c"); //value c is assigned to key 3
        //in this case (mapping letters of the alphabet to numeric order) each letter has a single key so there is no problem
        //in a scenery where more values would need to be assigned to the same key
        //just use lists with aggregate operations like it was shown above

        //here is an interesting example provided by java tutorials
        //this maps the words input in the program by the frequency they appear

        String[] args = {"if", "it", "is", "to", "be", "it", "is", "up", "to", "me"};

        Map<String, Integer> m = new HashMap<>();

        // Initialize frequency table from command line
        for (String str : args) {     //this loop is very instructive
            Integer freq = m.get(str);    //as here it sets the field freq to the up to date one from the str key
            m.put(str, (freq == null) ? 1 : freq + 1);  //and here it sets the value of the str key to one if the freq is null (meaning it was not already present in the map)
            //or if it was any number just add 1 to that number
            //really shows how to use loops, this concept of setting the variable by getting the updated state and then resetting it again
            //exploiting maximum potential from data structures achieving clean, concise and powerful code
            //the ternary operator is too good, to achieve the same result as above a lot of mess would have been done with if statements
            //W TERNARY OPERATOR W
        }
        //now in this program it is also possible to just change the implementation of Map to get different outputs (based on alphabetic order, number of frequency, etc...)
        System.out.println(m.size() + " distinct words:");
        System.out.println(m);

        //bulk operations are nothing special

        //Collection Views
        //Collection view methods allow Maps to be seen as Collection
        //-keySet() is the set of keys in the Map (it is a set because no duplicates keys are allowed in Maps)
        //-values() is the collection of values in the Map (not a set because there can be duplicates values for different keys)
        //-entrySet() is the set of key-value pairs which are of type Map.Entry, a small nested interface in Map

        //these methods are really important because they are the only means to iterate over a Map
        System.out.println("Collection View Methods: ");
        Map<Integer, String> ex1 = new HashMap<>();
        ex1.put(1, "a");
        ex1.put(2, "b");
        ex1.put(3, "c");

        //iterating over the set of keys with enhanced for
        for (Integer key : ex1.keySet())
            System.out.println("key: " + key);

        //or with iterator
        for (Iterator<Integer> it = ex1.keySet().iterator(); it.hasNext(); )
            System.out.println("key: " + it.next());
        //note: if you call remove() from an iterator on the keySet() or values() of a Map you remove the elements also from the Map
        //         same behavior of subList()

        //same with values
        for (String value : ex1.values())
            System.out.println("value: " + value);

        for (Iterator<String> it = ex1.values().iterator(); it.hasNext(); )
            System.out.println("value: " + it.next());

        //iterate over key-value pairs
        for(Map.Entry<Integer, String> pair : ex1.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());

        //collection views can be combined with bulk operation
        //resulting in a very potent tool

        //checking if two maps have the same key-value pairs:
        Map<Integer, String> comp1 = new HashMap<>();
        Map<Integer, String> comp2 = new HashMap<>();
        comp1.put(1, "hello");
        comp2.put(1, "hello");
        //comp2.put(2, "not equal if you uncomment");

        System.out.println("the two maps have same key-value pairs: " + comp1.entrySet().equals(comp2.entrySet()));

        //checking if the two maps have the same keys
        System.out.println("the two maps have the same keys: " + comp1.keySet().equals(comp2.keySet()));


















    }

}
