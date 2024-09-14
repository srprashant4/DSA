/**
 * This is a program to insert a node at the begining of a circular linked list.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionAtTheBegining {

    public static Node insertAtBegin(Node last, int data) {
        Node newNode = new Node(data);

        // If the list is null, return the new node.
        if(last == null) {
            newNode.next = newNode; // Make the new node a circular list.
            return newNode;
        }

        newNode.next = last.next;
        last.next = newNode;

        return last;
    }
    
    // Function to print the list
    public static void printList(Node last) {
        if(last == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Start from the head node
        Node head = last.next;
        while(true) { // loop until we come back to the head
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

        // Make it circular by linking the last node to the head
        last.next = first;

        System.out.println("The initial list is: ");
        printList(last);

        System.out.println("List after inserting -1 at the begin: ");
        last = insertAtBegin(last, -1);
        printList(last);
    }
}
