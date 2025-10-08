package DataStructures.Arrays;
public class ArrayDemo {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();

        arr.insertAtEnd(10);
        arr.insertAtEnd(20);
        arr.insertAtEnd(30);
        arr.insertAtBeginning(5);
        arr.insertAtPos(2, 15);
        arr.display(); // 5 10 15 20 30

        arr.deleteAtBeginning();
        arr.display(); // 10 15 20 30

        arr.deleteAtEnd();
        arr.display(); // 10 15 20

        arr.deleteAtPos(1);
        arr.display(); // 10 20

        System.out.println("Element at index 1: " + arr.get(1));
        arr.set(1, 25);
        arr.display(); // 10 25

        System.out.println("Contains 25? " + arr.contains(25));
        System.out.println("Index of 25: " + arr.search(25));
        System.out.println("Length: " + arr.length());
    }
}
