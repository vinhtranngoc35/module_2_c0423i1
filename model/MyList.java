package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList<E>{
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }
    // [] size 0 -> arr[0] = 1 -> [1];
    // [1] size 1 -> arr[1] = 2 -> [1,2]
    // [1,2,0,0...,0]
    public void add(E e){
        enSureCapacity();
        elements[size] = e;
        size++;
    }

    public void add(E e, int index){
        enSureCapacity();
        validateIndex(index);
        for (int i = size +1; i > index ; i--) {
            elements[i] = elements[i -1];
        }
        elements[index] = e;
        size++;
    }

    public void enSureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, size*2);
        }
    }

    public E remove(int index){
        validateIndex(index);
        E result = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return result;
    }

    public int size(){
        return size;
    }
    // [1,2,3]
    // [] add 1 , 2,3
    public Object clone(){
        // tao object moi
        MyList<E> result = new MyList<>(size);
        // add tung phan tu cua mang hien tai vao mang clone;
        for(int i =0; i < size; i++){
            result.add((E) elements[i]);
        }
        // tra ve object moi
        return result;
    }



    private void validateIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.format("%d out of %d array", index, size));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers1 = (ArrayList<Integer>) integers.clone();
        integers.add(1);
        System.out.println(integers1.size());
    }
}
