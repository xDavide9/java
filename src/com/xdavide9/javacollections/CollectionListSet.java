package com.xdavide9.javacollections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionListSet {

    CollectionListSet() {
        System.out.print("THE COLLECTION INTERFACE");
        //Collections are objects that store other objects
        //A collection framework is used to manipulate and work with collections
        //and is composed by interfaces, abstract data types, which usually form
        //a hierarchy, implementations of those interfaces (e.g. reusable data structures)
        //and algorithms (e.g methods)

        //A part from the java collection framework there are also the C++ standard template library (STL)
        //and Smalltalk's collection hierarchy

        //Among all the benefits collection provide to the programmer there are:
        //reduce effort
        //increase performance
        //code reusability

        //INTERFACES
        //there are two trees: one that starts with the Collection interface and the other with the Map interface
        //all the interfaces are generic
        //lets see now the interfaces one by one:

        //-Collection
        //This is the root of the collection hierarchy and represents a collection whose objects are called elements
        //used when maximum generality is desired

        //-Set
        //A collection that cannot accept duplicates

        //-List
        //An ordered collection that can have duplicates, the programmer knows the position of every element
        //in the list because he can manipulate it thanks to the index

        //-Queue
        //A collection used to hold elements before processing
        //a part from generic collections functions it provides insertions, extractions and inspections methods
        //they can oder elements in a FIFO manner (first-in, first-out)

        //-Dequeue
        //Still a collection used to hold elements before processing
        //a part from generic collections functions it provides insertions, extraction and inspections methods
        //they can order elements both in FIFO manner and in a LIFO manner (last-in, first-out)

        //-Map
        //object that associates a keys to value, where there cannot be any duplicate key

        //-SortedSet
        //A set that maintains its elements in ascending order

        //-SortedMap
        //A map that maintains its mappings in ascending order

        //THE COLLECTION INTERFACE
        //A group of objects that are called elements
        //Used when maximum generality is needed
        //for example it can be used in the conversion constructor
        //where you use a collection object to create a specialised collection:

        Collection<Integer> c = new LinkedList<>();  //notice the use of the diamond operator <>
        List<Integer> list = new ArrayList<>(c);
        //where LinkedList and ArrayList are both implementations of List
        //in this case c is empty but it's just a demonstration

        //there are so many methods to do whatever in the Collection interface
        //like add, remove, contains, size, isEmpty etc.

        //TRAVERSING COLLECTIONS

        //adding some numbers too to list first
        for (int i = 0; i < 10; i++) {
            list.add(i);    //autoboxing pog
        }

        //now there are 3 ways to traverse collections: using aggregate operations,
        //with the for-each construct and by using iterators

        //-AGGREGATE OPERATIONS
        //In JDK8 and later the preferred method of iterating over a collection is to obtain a stream (through the stream() method)
        //and perform aggregate operations on it. Aggregate operations often use with lambda expressions

        //for example:
        System.out.print("\nOnly evens in collection: ");
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::print);
        //this filters even numbers from the list and prints them to standard output

        //-THE FOR-EACH CONSTRUCT
        System.out.print("\nThe entire collection (enhanced for): ");
        for (int i : list)              //unboxing pog
            System.out.print(i);

        //-ITERATORS
        //similarly to streams you can obtain an iterator through the iterator() method
        //here a loop is needed which is run until iterator.hasNext() (meaning there is an element next) returns true
        //to obtain that element call iterator.next();

        System.out.print("\nThe entire collection (iterator): ");
        for (Iterator<?> it = list.iterator(); it.hasNext(); )
            System.out.print(it.next());

        //this is only good if you need to have filter, cause the enhanced for hides the iterator
        //and even then stream are still preferable

        //-BULK OPERATION
        //those are operation that are performed on the entire collection
        /*
        containsAll — returns true if the target Collection contains all of the elements in the specified Collection.
        addAll — adds all of the elements in the specified Collection to the target Collection.
        removeAll — removes from the target Collection all of its elements that are also contained in the specified Collection.
        retainAll — removes from the target Collection all its elements that are not also contained in the specified Collection.
                        That is, it retains only those elements in the target Collection that are also contained in the specified Collection.
        clear — removes all elements from the Collection.
         */

        //ToArray() methods
        //allow you to turn a collection into an array
        Object[] array = c.toArray();

        //THE SET INTERFACE
        System.out.print("\n\nTHE SET INTERFACE");
        //A set is a collection that cannot have duplicates
        //there are 3 implementations of this interface
        //HASHSET, the fastest one but no order
        //TREESET, much slower but orders elements depending on their value
        //LINKEDHASHSET, slightly more expensive than a simple HashSet
        //                          but orders elements in the order they were inserted

        //for example if you wanted eliminate the duplicates from a collection
        //you could create a Set with the conversion constructor

        //creating a collection with 10 random numbers
        List<Integer> initialList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            initialList.add(random.nextInt(10));
        System.out.print("\nInitial collection: " + initialList);


        //creating a set from that collection to remove duplicates
        Set<Integer> noDuplicates = new HashSet<>(initialList);
        System.out.print("\nNo duplicates (all elements appear once): " + noDuplicates);

        //not how Set<Integer> is used as type of numSet
        //aka the Interface type
        //this is strongly encouraged because it gives the flexibility to changing
        //implementation simply by changing the constructor and everything else related
        //to the original Set will still work (methods parameters, variable references...)
        //because the interface type can correspond to any of its implementation types

        //there are bulk operations here too, really similar to maths sets (i guess they take the name from them)
        /*
        s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
        s1.addAll(s2) — transforms s1 into the union of s1 and s2.
                               (The union of two sets is the set containing all of the elements contained in either set.)
        s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2.
                                  (The intersection of two sets is the set containing only the elements common to both sets.)
        s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2.
                                    (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)
         */

        //in order to perform bulk operation without modifying the set given set just create a copy of that set and perform operation there

        //Array operations do not differ from the ones in the Collection Interface
        //Note: remember that this is an interface hierarchy so everything from top-level interfaces is present in sub-interfaces (e.g the add() method)

        //MORE ON AGGREGATE OPERATION (THEY ARE THE REAL DEAL)
        System.out.print("\n\nSOME EXAMPLES OF AGGREGATE OPERATIONS");
        //the filter() and map() methods runnable on streams can create interesting combinations
        //example:
        //A list which consists of a series of strings of numbers needs to be converted to a list of only the even numbers
        //can do that by using a combination of map(), filter() and collect()

        //map() takes a Function mapper object as parameter which is basically a function that is going to be run on every element of the list
        //          (an alternative to map is forEach(Consumer consumer) but map() is faster)
        //          (the difference between the two is that maps returns a new list and forEach operates on the same list)
        //filter() takes a Predicate predicate object as parameter  which is the condition upon which the filter method actually filters
        //collect() takes a Collector collector object as parameter which can be obtain through the Collectors class and basically converts the stream
        //            to any Collection implementation depending on which collector was chosen
        //Function, Consumer, Predicate, Collector are all functional interfaces meaning you can pass lambda expressions or method references

        List<String> list1 = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        System.out.print("\nInitial list: " + list1);

        List<Integer> evens = list1.stream()                                                 //obtain a stream from the list
                .map(string -> Integer.valueOf(string))       //runs Integer.valueOf(String string) to every element of the stream
                .filter(num -> num % 2 == 0)                   //filter based on the provided predicate
                .collect(Collectors.toList());
        System.out.print("\nOnly evens in list: " + evens);

        List<String> unformattedList = Arrays.asList("mArio", "luIgi", "fRanCeSco", "anDrEa");
        System.out.print("\nUnformatted Names: " + unformattedList);

        List<String> formattedList = unformattedList.stream().map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase()).collect(Collectors.toList());
        System.out.print("\nFormatted Names: " + formattedList);

        //remember in lambdas if you have more expressions that evaluate to a single one (because they must evaluate to a single one)
        //use the {} brackets and the return keyword to return the value wanted
        //example:

        List<String> upperCaseNamesAndLength = unformattedList.stream().map(s -> {
            String name = s.toUpperCase();
            int length = s.length();
            return name + " " + length;
        }).toList();
        //a lame example cause it could be simplified without the brackets but w/e
        System.out.print("\nUpper Case with Length: " + upperCaseNamesAndLength);

        //THE LIST INTERFACE
        System.out.print("\n\nTHE LIST INTERFACE");
        //A list is an ordered collection
        //There are two implementations: ArrayList (generally better performing) and LinkedList (better in some circumstances)
        //A part from the features inherited by Collection the List Interface provides positional access to elements

        //example:
        class ShowCase {
            public static <E> void swap(List<E> a, int i, int j) {
                E temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
            }
            //this method which is provided by java in the Collections class swaps two elements with the corresponding indexes in a List
            //note that it uses generics so it works on any list

            public static void shuffle(List<?> list, Random rnd) {
                for (int i = list.size(); i > 1; i--)
                    swap(list, i - 1, rnd.nextInt(i));
            }
            //this other method, still provided in the Collections class shuffles an entire list using the swap algorithm previously described
            //iterates backwards in the list
        }

        //it is also possible to create list from the Arrays class
        List<Integer> ex = Arrays.asList(0, 1, 2, 3, 4, 5);

        //ITERATORS IN LISTS
        System.out.println("\nIterators (covered well):");
        //provide first a more detailed description of Iterators which were not properly covered

        //An iterator works with an imaginary pointer that is put in between elements of a Collection
        //that is put before element 0 when calling iterator() on a Collection

        /*
        public interface Iterator<E> {
            boolean hasNext();
            E next();
            void remove(); //optional
        }
         */

        //this is what the Iterator interface looks like
        //when calling E next() (notice the generics to make it available for every type)
        //it returns the element positioned right ahead of the current position of the imaginary pointer
        //the first call of next() returns the first element (since the pointer is put before element 0)
        //and also moves the pointer between element 0 and 1
        //the second call of next() returns the second element (since the pointer is put between element 0 and 1)
        //and also moves the pointer between element 1 and 2
        //refer to pictures on https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
        //example:

        List<Integer> ex1 = Arrays.asList(69, 3, 169);
        Iterator<Integer> iterator = ex1.iterator();
        //the pointer is now before element 0
        System.out.println("element 0: " + iterator.next());
        //iterator.next() both returned element 0 and moved the pointer 1 position further (between 0 and 1)
        //so now another call to it will return element 1 and move the pointer another position further (between 1 and 2)
        System.out.println("element 1: " + iterator.next());
        //and again now another call to get the last element in this case
        System.out.println("element 2: " + iterator.next());
        //but now the pointer is between 2 and 3 meaning that another call to next() will try to retrieve
        //element 3 which is non-existent in this list so how to fix it?
        //with the hasNext() method:

        List<Integer> ex2 = Arrays.asList(12, 23, 34);
        Iterator<Integer> iterator1 = ex2.iterator();
        if (iterator1.hasNext())
            System.out.println(iterator1.next());
        if (iterator1.hasNext())
            System.out.println(iterator1.next());
        if (iterator1.hasNext())
            System.out.println(iterator1.next());
        if (iterator1.hasNext())
            System.out.println(iterator1.next());
        //in this example iterator1.next() is called only after iterator1.hasNext() is true
        //meaning that it is safe to do it because it was checked that the index would not be out of bounds
        //in this specific example the last call to next() is not called because there are only 3 elements to iterate through and not 4

        //but this code is really repetitive so it is possible to just wrap it in a loop
        List<Integer> ex3 = Arrays.asList(99, 11, 22);

        //Iterator iterator2 = ex3.iterator();
        //while (iterator2.hasNext())
        //    System.out.print(iterator2.next() + "\n");

        //but better with the for loop because it limits the scope of the iterator only needed in this example
        for (Iterator<Integer> it = ex3.iterator(); it.hasNext(); )
            System.out.println(it.next());
        //note how the increment part is missing in the for loop
        //(remember the for construct is:
        //for (initialisation; condition; increment)
        //where until the condition based on the initialised variable increment each iteration is true the loop continues to run
        //in this case the increment part is already provided by next() which moves the imaginary pointer ahead in the list
        //note also the important on the condition actually provided by hasNext() which is crucial for loops as it is well known

        //there is also remove() which removes the previously returned element by next
        List<Integer> ex4 = new ArrayList<>();
        ex4.add(1);
        ex4.add(10);
        ex4.add(2);
        ex4.add(3);
        ex4.add(10);
        //removing the 10;
        Iterator<Integer> it1 = ex4.iterator();
        it1.next();
        it1.next();
        it1.remove();
        System.out.println(ex4);
        //can also do this with loop and condition which is better because it is not really known where the element(s) to be removed are located
        //in the collection and this is the safest way to remove items from a single collection so it (REALLY IMPORTANT)

        for (Iterator<Integer> it = ex4.iterator(); it.hasNext(); ) {
            if (it.next() == 10)
                it.remove();
        }
        System.out.println(ex4);
        //but as intellij suggests it is possible to do all of this with just removeIf()

        List<Integer> ex5 = new ArrayList<>();
        ex5.add(11);
        ex5.add(12);
        ex5.add(133);
        ex5.add(13);
        ex5.removeIf(n -> n == 133);
        System.out.println(ex5);

        //it's interesting to note that methods can do multiple things at the same time even tho
        //generally we are prone to thinking (good english) methods just do what they say
        //but they actually do multiple things
        //like removeIf tries to remove elements depending on the given predicate
        //but also returns a boolean value whether it was able to do so or not
        //like also the add method returns true it was possible to add the element to the collection or not
        //(particularly useful with Sets since you cannot have duplicates in those)

        //all this time though there was a better iterator which is only available for lists
        //which is the ListIterator which extends Iterator and adds previous() and hasPrevious()
        //through a special constructor in ListIterator it is also possible to start the imaginary pointer
        //at a specific location (for example by passing list.size() you can start it at the end of the list)
        List<Integer> ex6 = new ArrayList<>(ex5);
        ListIterator<Integer> it = ex6.listIterator(ex6.size());    //putting the starting pointer of the iterator at the beginning of the list
        System.out.println(it.previous());  //and previous() works like next() but in reverse way in combo with hasPrevious()
        //of course if you call next() and previous() consecutively you would return the same element twice
        System.out.println(it.previousIndex());  //exactly
        System.out.println(it.previousIndex());

        //nextIndex() returns the index of the element that would be returned by a call to next()
        //previousIndex() returns the index of the element that would be returned by a call to previous()
        //a call to nextIndex() when you are at the last element returns list.size
        //a call to previousIndex() when you are at the first element returns -1
        //upon this are is built the List.indexOf(Object o) method
        //note that previousIndex() or nextIndex() only returns the index of the element and does not move the imaginary pointer

        //NOTE:
        //understanding the ternary operator within if
        //in an if you run code if the expression evaluates to true
        if (1 == 1 ? 2 == 2 : 3 == 3)
            System.out.println(123);
        else
            System.out.println(456);
        //so if you want to run what's within the if depending on the first condition either the first expression or the second must evaluate to true
        //so in this case 1==1 so the if evaluates if 2==2 and since it's true it runs the if
        //if 2==3 for example then the else would have run
        //if instead we don't have 1==1 but a false condition then it evaluates 3==3 and if true it runs the if, if false it runs the else
        //this is to better understand the implementations of some method that work with iterators like:

        /*
        public int indexOf(E e) {
            for (ListIterator<E> it = listIterator(); it.hasNext(); )
                if (e == null ? it.next() == null : e.equals(it.next()))
                    return it.previousIndex();
            // Element not found
            return -1;
        }
        //here the first thing the algorithm does to check if e == null
        //if it's true then it checks if it.next() == null (by calling it.next() it also moves the pointer up
        //if this is true then the element e and the object returned by next are both null and therefore
        //it returns it.previousIndex() (because we want the index of the element just compared with next, because next moved the pointer and previousIndex just returns
        //the previous index without moving it
        //if e != null then it can check with e.equals(it.next()) (Object.equals(Object o) cannot be invoked when either of the Objects are null, throws
        //and therefore if e.equals(it.next()) returns true eventually then it returns the previous index following the same logic as in the other case
        //this is of course all done in the standard for loop to iterate through the whole list while calling next() to move the pointer and hasNext() to check whether to exit the loop or not
        //if the loop exists (meaning the return statement was never executed it means the element is not found and the index returned is -1
        //note that it.next() can only be called once per iteration (either e == null or is an initialised object)
         */

        //there are also some other methods provided by ListIterator like set(Object o) which sets a new value for the last call of next or previous
        //which is used for example in the implementation of replace()

        /*
        public static <E> void replace(List<E> list, E val, E newVal) {
            for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
                if (val == null ? it.next() == null : val.equals(it.next()))
                    it.set(newVal);
        }

        //it kind of is the same thing with the ternary operator in the if (very clear and concise code this is definitely a good to use in projects)
        //in each iteration of the loop if val == null then we need to prevent a null pointer exception
        //and to do that we make it check if it.next()==null so we assign null to null which is fine
        //in the other case just check if val.equals(it.next()) during each iteration and if this evaluate to true then run set with new val from it
        //because set() works with the last element returned by either next() or previous() like remove()
         */

        //these iterators just go throw all the list like a for loop would for a simple array but have more options and are better of course
        //the add() method (ListIterator.add() not Collection.add()) inserts a new element right before the current position of the cursor

        //RANGE VIEW OPERATION
        //the range view operation, subList(int fromIndex, int toIndex) emulates
        //for (int i = fromIndex; i < toIndex; i++) {
        //    ...
        //}
        //any method that expects a List can be run on a subList so that you just perform it on that part of the list called view
        //anything can be done with the subList operation but we should be careful when doing it

        //here is a program that creates you a specified number of hands with a specified number of cards per hand from a 52 card deck
        int numHands = 4;
        int cardsPerHand = 12;

        // Make a normal 52-card deck.
        String[] suit = {
                "spades", "hearts",
                "diamonds", "clubs"
        };

        String[] rank = {
                "ace", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "jack", "queen", "king"
        };

        List<String> deck = new ArrayList<>();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(rank[j] + " of " + suit[i]);

        // Shuffle the deck.
        Collections.shuffle(deck);

        if (numHands * cardsPerHand > deck.size()) {
            System.out.println("Not enough cards.");
            return;
        }

        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
    }
    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);    //get the hand view from the shuffled deck
        List<E> hand = new ArrayList<>(handView);   //create the hand from the hand view
        handView.clear();   //clear the hand view (remove cards from the deck)
        return hand;
    }
}
