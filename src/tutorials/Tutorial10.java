package tutorials;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Tutorial10 {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();

        stringBox.setItem("New item");

        System.out.println(stringBox.getItem());

        Integer[] intArray = {1,2,3};
        String[] strArray = {"A", "B", "C"};

        printArray(intArray);
        printArray(strArray);

        NumberBox<Integer> intNumBox = new NumberBox<>();
        NumberBox<Double> doubleNumBox = new NumberBox<>();

        Pair<String, Integer> pair = new Pair<>("Agnes", 35);
        System.out.println("Key: " + pair.getKey() + " and the value is: " + pair.getValue());

    }

    public static <T> void printArray(T[] array){
        for (T element : array){
            System.out.println(element);
        }
    }

    public static void printList(List<?> list){
        for(Object element: list){
            System.out.println(element);
        }
    }

    public static void printNumbers(List<? extends Number> list){
        for(Object element: list){
            System.out.println(element);
        }
    }

    public static void addInteger(List<? super Integer> list){
        list.add(10);
    }

/*
*  Generics in Java: (Data types)
* Generics basically enable us to define classes, interfaces, and methods in Java,
* with a placeholder for the type or parameter of data we want to use in that class or interface or method
*
* Generic classes - they are classes that have placeholders for the type of data that their properties/fields will have and the parameters or return types of their methods.
* Generic Methods -
* Bounded type Parameters - We can restrict the type of data that can be passed to a generic by using the bounded types, we do this by using extends keyword
* Wildcards in Generics - allows us to use generics in a more flexible way, the ? is the wildcard character in generics
* There are 3 types of wildcards in Java generics
*  - Unbounded wildcards
*  - Upper bounded wildcards
*  - Lower bounded wildcards
*
* Generic Pair class:
*
*
* ASSIGNMENT:
* Change our Stack class to use Generics
*
* */

}

class Box<T> {
    private T item;

    public void setItem(T newItem){
        this.item = newItem;
    }

    public T getItem(){
        return item;
    }

    public String boxString(){
        return item.toString();
    }
}

class NumberBox<T extends Number>{
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public double doubleValue(){
        return number.doubleValue();
    }
}

class Pair<K, V>{
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){ return key; }
    public V getValue(){ return value; }
}



