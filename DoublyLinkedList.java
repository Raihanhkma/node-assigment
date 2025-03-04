package linkedlist;

public class DoublyLinkedList {
    Node head; // Head of the list
    Node tail; // Tail of the list

    // Node class for the doubly linked list
    static class Node {
        String data;
        Node next;
        Node prev;

        // Constructor
        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a node at the front of the list
    public void addFront(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // If the list was empty, head and tail are the same
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to add a node at the end of the list
    public void addEnd(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode; // If the list was empty, head and tail are the same
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to print the list from head to tail
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Adding nodes to the list
        list.addEnd("Node 1");
        list.addEnd("Node 2");
        list.addFront("Node 0");
        list.addEnd("Node 3");

        // Print the list
        System.out.println("Doubly Linked List:");
        list.printList();
    }
}