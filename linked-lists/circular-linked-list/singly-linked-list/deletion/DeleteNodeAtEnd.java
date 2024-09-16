/**
 * Program to delete the last node in a circular linked list.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodeAtEnd {

    public static Node deleteAtEnd(Node last) {

        // If the list is empty, return null.
        if(last == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // If there is only one node in the list, return null.
        if(last.next == last) {
            return null;
        }

        // Start traversing from the begining of the list.
        Node temp = last.next;

        while(true) {
            if(temp.next == last) {
                break;
            }
            temp = temp.next;
        }

        // Once you reach the 2nd last node, assign the head to temp.next and make temp the last node.
        temp.next = last.next;
        last = temp;

        return last;
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

            if(head == last.next) {
                break;
            }
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

        System.out.println("The initial list is: ");
        printList(last);

        System.out.println("The list after removing the last node is: ");
        last = deleteAtEnd(last);
        printList(last);
    }
}
