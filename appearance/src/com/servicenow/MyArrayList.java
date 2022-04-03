package com.servicenow;

// This is also called Bag data structure
import java.util.Arrays;
import java.util.function.Consumer;

public class MyArrayList<T> {

    private Object[] myStore;
    private int actSize;

    public MyArrayList(){
        myStore = new Object[10]; // Default size
        actSize = 0;
    }

    public MyArrayList(int capacity) {
        myStore = new Object[capacity];
        actSize = 0;
    }

    public void add(Object obj){
        if (myStore.length - actSize <= 5){
            resizeDynamicArray();
        }
        myStore[actSize] = obj;
        actSize++;
    }

    public Object get(int index){
        if(index < actSize){
            return myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object remove(int index) {
        if (index < actSize) {
            Object obj = myStore[index];
            myStore[index] = null;
            int tmp = index;

            while (tmp < actSize){
                myStore[tmp] = myStore[tmp + 1];
                myStore[tmp + 1] = null;
                tmp++;
            }

            actSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void forLoop() {
        Consumer<Object> action = t -> {
            if (t == null) {
            } else {
                System.out.println(t.toString());
            }
        };

        Arrays.stream(myStore).forEach(action);
    }

    public int size(){
        return actSize;
    }

    private void resizeDynamicArray(){
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
        System.out.println("\nNew length: "+ myStore.length);
    }

    public static void main(String a[]){
        MyArrayList<Integer> mal = new MyArrayList<Integer>();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        mal.forLoop();
        for(int i = 0; i < mal.size(); i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i = 0; i < mal.size(); i++){
            System.out.print(mal.get(i)+" ");
        }
    }
}