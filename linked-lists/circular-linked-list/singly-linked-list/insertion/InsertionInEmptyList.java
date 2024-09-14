/**
 * This is a program to insert a node in an empty circular linked list.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionInEmptyList {

    // Function to insert a node into an empty circular singly linked list
    public static Node insertInEmptyList(Node last, int data) {

        // Insert only if the list is empty.
        if(last != null) {
            System.out.println("Not inserting in the list since it is not empty.");
            return last;
        }

        // Create a new node
        Node newNode = new Node(data);

        // Point newNode to itself
        newNode.next = newNode;

        return newNode;
    }

    // Function to print the list
    public static void printList(Node last) {
        if (last == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Start from the head node
        Node head = last.next;
        while (true) { // loop until we come back to the head
            System.out.print(head.data + " ");
            head = head.next;
            if (head == last.next) break;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node last = null;
        System.out.println("The initial list is: ");
        printList(last);

        System.out.println("After inserting a node in the empty list: ");
        last = insertInEmptyList(last, 0);
        printList(last);
    }
}
