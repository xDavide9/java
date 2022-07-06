package com.xdavide9.javacollections;

import java.util.*;

public class ObjectOrdering {

    ObjectOrdering() {

        //elements in a collection are sorted via
        //Collections.sort(Collection collection)
        //depending on the type of the provided collection there are different rules
        //upon which the elements are sorted
        //for example Strings are sorted based on alphabetical order
        //or Dates based on chronological order
        //both of those classes (and also the others which can be sorted)
        //implement the Comparable interface which provides a natural method for sorting

        //examples:
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("the");
        list1.add("a");

        //note that in all the classes with final s generally there are static methods to work with the type without the s
        Collections.sort(list1);
        System.out.println("Sorted list (alphabetical order): " + list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(14);
        list2.add(-2);
        list2.add(-56);

        Collections.sort(list2);
        System.out.println("Sorted list (smaller to greater): " + list2);

        //it is also possible to provide a Comparable in an overloaded version of sort()
        //to provide a method of ordering different from the natural one

        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                if (o1 < o2)
                    return 1;
                return 0;
            }
        });
        System.out.println("Sorted list (greater to smaller): " + list2);

        //this example is pointless because this functionality is already introduced by Collections.reverseOrder()
        //so Collections.sort(list2, Collections.reverseOrder()) would have been cleaner but it gets the point

        //here the Comparator interface is a functional interface and it defines a the compare(T o1, T o2) method
        //here rules between the two objects are provided in the following way
        //if the first element is less than the other return a negative value
        //if the first element is equal to the other return return 0
        //if the first element is less than the other return a positive value

        //this really shows the power of the java collection framework

        //now that object order has been discussed it's time to introduce sorted interfaces

        //THE SORTEDSET INTERFACE
        System.out.println();
        System.out.println("THE SORTEDSET INTERFACE");

        //the SortedSet interface differs from the Set interface in the fact that
        //the elements are sorted depending on the Comparator provided in the constructor
        //the implementation of SortedSet is TreeSet and if its comparator is null
        //it just follows the natural ordering criteria of the specified type

        SortedSet<Integer> set1 = new TreeSet<>(Collections.reverseOrder());
        set1.add(1);
        set1.add(1);
        set1.add(34);
        set1.add(75);
        set1.add(145);
        set1.add(-145);
        set1.add(23);

        System.out.println("A SortedSet (greater to smaller): " + set1);

        //RANGE VIEW
        //there are also particular range view operations defined as follows:
        /*
        SortedSet<E> subSet(E fromElement, E toElement);
        SortedSet<E> headSet(E toElement);
        SortedSet<E> tailSet(E fromElement);
         */

        //they are pretty self explanatory
        System.out.println("subSet: " + set1.subSet(75, 1));    //including the first argument (75) but not the second (1) as it is defined by Iterators
        System.out.println("headSet: " + set1.headSet(34));    //not including the argument of course
        System.out.println("tailSet: " + set1.tailSet(34));         //still not including

        //NOTE
        //the comparator provided to the TreeSet can be obtained via
        System.out.println("comparator: " + set1.comparator());

        //ENDPOINT OPERATIONS
        //they are first() and last() and self-explanatory
        System.out.println("first: " + set1.first());
        System.out.println("last: " + set1.last());

        //THE SORTEDMAP INTERFACE
        /*
        public interface SortedMap<K, V> extends Map<K, V>{
            Comparator<? super K> comparator();
            SortedMap<K, V> subMap(K fromKey, K toKey);
            SortedMap<K, V> headMap(K toKey);
            SortedMap<K, V> tailMap(K fromKey);
            K firstKey();
            K lastKey();
        }
         */

        //this is the interface declaration and it is obvious that it is basically the same as a SortedSet
        //only difference being that the ordering is performed on the keys
        //the implementation is TreeMap

        SortedMap<Integer, String> map1 = new TreeMap<>(Collections.reverseOrder());
        map1.put(1, "a");
        map1.put(2, "b");
        map1.put(3, "c");

        System.out.println("A SortedMap (greater to smaller): " + map1);












    }

}
