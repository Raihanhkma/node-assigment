package Linkedlist;

public class SimpleListNode {
    Node head;

    static class Node {
        String data;
        Node next;

        // Constructor
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SimpleListNode list = new SimpleListNode(); // Empty linked list

        // Inserting 4 nodes with data (not linked yet)
        Node raihan = new Node("raihan");
        Node bari = new Node("bari");
        Node listNode = new Node("list");
        Node lasti = new Node("lasti");

        // Linking the list together
        list.head = raihan;
        raihan.next = bari;
        bari.next = listNode;
        listNode.next = lasti;

        // Print the initial list
        printList(list.head);

        // Insert Bill before Raihan
        Node bill = new Node("Bill");
        bill.next = list.head;
        list.head = bill;

        // Print the updated list
        System.out.println("\nUpdated list after inserting Bill before Raihan:\n");
        printList(list.head);

        // Insert Sue after Bari
        Node sue = new Node("Sue");
        bari.next = sue;
        sue.next = lasti;

        // Print the updated list
        System.out.println("\nUpdated list after inserting Sue after Bari:\n");
        printList(list.head);
    }

    // Helper method to print the linked list
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}