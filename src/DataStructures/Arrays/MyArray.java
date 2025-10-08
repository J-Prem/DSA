package DataStructures.Arrays;
import java.util.Iterator;

// Generic Dynamic Array Class
class MyArray<T> implements Iterable<T> {
    private T[] arr;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArray() {
        capacity = 10;
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Insert operations
    public void insertAtEnd(T val) {
        if (size == capacity)
            resize();
        arr[size++] = val;
    }

    public void insertAtBeginning(T val) {
        if (size == capacity)
            resize();
        for (int i = size; i > 0; i--)
            arr[i] = arr[i - 1];
        arr[0] = val;
        size++;
    }

    public void insertAtPos(int pos, T val) {
        if (pos < 0 || pos > size)
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        if (size == capacity)
            resize();
        for (int i = size; i > pos; i--)
            arr[i] = arr[i - 1];
        arr[pos] = val;
        size++;
    }

    // Delete operations
    public void deleteAtEnd() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Array is empty");
        size--;
    }

    public void deleteAtBeginning() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Array is empty");
        for (int i = 0; i < size - 1; i++)
            arr[i] = arr[i + 1];
        size--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        for (int i = pos; i < size - 1; i++)
            arr[i] = arr[i + 1];
        size--;
    }

    // Access operations
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        return arr[index];
    }

    public void set(int index, T val) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        arr[index] = val;
    }

    // Search operations
    public int search(T key) {
        for (int i = 0; i < size; i++)
            if (arr[i].equals(key))
                return i;
        return -1;
    }

    public boolean contains(T key) {
        return search(key) != -1;
    }

    // Utility functions
    public int length() {
        return size;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Iterable support
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public T next() {
                return arr[index++];
            }
        };
    }
}