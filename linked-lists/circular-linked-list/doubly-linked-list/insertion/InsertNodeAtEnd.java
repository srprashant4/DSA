/**
 * Program to insert a node at the end of a circular doubly linked list.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
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

public class InsertNodeAtEnd {

    public static Node insertAtEnd(Node first, int data) {
        Node newNode = new Node(data);

        // If the list is empty, make newNode circular and return the newNode.
        if(first == null) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        Node curr = first.prev;

        curr.next.prev = newNode;
        newNode.next = curr.next;
        curr.next = newNode;
        newNode.prev = curr;

        return first;
    }

    // Method to print the list.
    public static void printList(Node first) {
        if(first == null) {
            return;
        }

        Node curr = first;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while(curr != first);

        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        first.next = new Node(1);
        first.next.prev = first;
        first.next.next = new Node(2);
        first.next.next.prev = first.next;
        first.next.next.next = new Node(3);
        first.next.next.next.prev = first.next.next;
        first.next.next.next.next = first;
        first.prev = first.next.next.next;

        System.out.println("The initial list is: ");
        printList(first);

        System.out.println("List after inserting 4 at the end: ");
        first = insertAtEnd(first, 4);
        printList(first);
    }
}
