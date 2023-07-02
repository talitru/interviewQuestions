package il.co.ilrd.InterviewQuestions;


import java.util.NoSuchElementException;

public class ThreadSafeGenericArray<T> {
    private T[] array;
    private int size;

    public ThreadSafeGenericArray(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public synchronized void push(T item) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = item;
        size++;
    }

    public synchronized T pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size--;
        T item = array[size];
        array[size] = null;
        return item;
    }
}
