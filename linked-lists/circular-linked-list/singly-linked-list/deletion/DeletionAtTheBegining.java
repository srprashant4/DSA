/**
 * Program to delete the first node from the circular linked list.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeletionAtTheBegining {

    // Method to delete the first node.
    public static Node deleteAtBegin(Node last) {

        // Return null if the list is empty.
        if(last == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // Return null if there is only one node.
        if(last.next == last) {
            return null;
        }

        // Delete the first node.
        last.next = last.next.next;

        return last; // The last node won't change.
    }
    
    // Method to print the list.
    public static void printList(Node last) {

        // Return null if the list is empty.
        if(last == null) {
            return;
        }

        Node head = last.next;
        while(true) {
            System.out.print(head.data + " ");
            head = head.next;

            if(head == last.next) break;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node last = new Node(3);

        first.next = second;
        second.next = third;
        third.next = last;
        last.next = first;

        System.out.println("The initiallist is: ");
        printList(last);

        System.out.println("List after deleting the first node: ");
        last = deleteAtBegin(last);
        printList(last);
    }
}
