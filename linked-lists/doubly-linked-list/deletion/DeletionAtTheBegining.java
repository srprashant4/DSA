/**
 * Java Program to delete a node from the beginning of a Doubly Linked List.
 */
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DeletionAtTheBegining {

    // Function to delete the first node (head) of the list 
    // and return the second node as the new head
    public static Node deleteAtBegin(Node head) {

        // If empty, return null
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // if there is only one node, return null.
        if(head.next == null) {
            return null;
        }

        // Move head to the next node
        head = head.next;

        // Set prev of the new head
        head.prev = null;

        return head;
    }
    
    // Method to print the list.
    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        System.out.println("Initial list is: ");
        printList(head);

        System.out.println("List after deleting the first node: ");
        head = deleteAtBegin(head);
        printList(head);
    }
}
