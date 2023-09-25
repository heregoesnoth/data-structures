import java.util.Arrays;

public class MyLinkedList {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    MyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    void insert(int pos, int value) {
        Node newNode = new Node(value);

        if (pos == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node node = traverseToPos(pos - 1);
            newNode.next = node.next;
            node.next = newNode;
        }

        this.length++;

    }

    Node traverseToPos(int pos) {
        int counter = 0;
        Node currentNode = this.head;
        while (counter != pos) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode;
    }

    int[] printList() {
        int[] array = new int[this.length];
        Node currentNode = this.head;
        int pos = 0;
        while (currentNode != null) {
            array[pos++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.insert(0, 15);
        myLinkedList.insert(0, 20);
        myLinkedList.insert(0, 25);
        myLinkedList.insert(2, 90);
        System.out.println(Arrays.toString(myLinkedList.printList()));
    }


}
