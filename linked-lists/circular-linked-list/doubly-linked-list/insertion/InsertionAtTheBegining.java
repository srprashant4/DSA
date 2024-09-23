/**
 * Program to insert a node at the begining of a circular doubly linked list.
 * 
 * Time Complexity: O(1)
 * Space Complexoty: O(n)
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

public class InsertionAtTheBegining {

    public static Node insertAtBegin(Node first, int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the newNode circular and return it.
        if(first == null) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        first.prev.next = newNode;
        newNode.prev = first.prev;
        first.prev = newNode;
        newNode.next = first;

        return newNode;
    }

    // Method to print a list.
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

        System.out.println("List after inserting -1 at the begining: ");
        first = insertAtBegin(first, -1);
        printList(first);
    }
}
