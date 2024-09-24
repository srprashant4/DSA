import java.util.Scanner;

/**
 * Program to insert a node in various ways in a circular doubly linked list.
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

public class AllInsertionOperations {

    public static Node insertAfterSpecifiedNode(Node first, int data, int givenNode) {
        Node newNode = new Node(data);

        if(first == null) {
            System.out.println("The list is empty.");
            return null;
        }

        Node curr = first;
        do {
            if(curr.data == givenNode) {
                curr.next.prev = newNode;
                newNode.next = curr.next;
                curr.next = newNode;
                newNode.prev = curr;
                return first;
            }
            curr = curr.next;
        } while(curr != first);

        System.out.println("The specified node not found in the list.");

        return first;
    }

    public static Node insertAtGivenPos(Node first, int data, int pos) {
        Node newNode = new Node(data);

        if(pos <= 0) {
            System.out.println("Invalid position.");
            return first;
        }

        if(first == null && pos == 1) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        if(first == null && pos > 1) {
            System.out.println("Invalid position.");
            return first;
        }

        if(first != null && pos == 1) {
            newNode.prev = first.prev;
            first.prev.next = newNode;
            first.prev = newNode;
            newNode.next = first;
            return newNode;
        }

        Node curr = first;
        int count = 1;
        while(curr.next != first) {
            if(count == pos - 1) {
                break;
            }
            curr = curr.next;
            count++;
        }

        if(count < pos - 1) {
            System.out.println("Invalid position.");
            return first;
        }

        curr.next.prev = newNode;
        newNode.next = curr.next;
        curr.next = newNode;
        newNode.prev = curr;

        return first;
    }

    public static Node insertAtEnd(Node first, int data) {
        Node newNode = new Node(data);

        if(first == null) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        newNode.prev = first.prev;
        first.prev.next = newNode;
        newNode.next = first;
        first.prev = newNode;

        return first;
    }

    public static Node insertAtBegin(Node first, int data) {
        Node newNode = new Node(data);

        if(first == null) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        first.prev.next = newNode;
        newNode.prev = first.prev;
        newNode.next = first;
        first.prev = newNode;

        return newNode;
    }
    
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

        System.out.println("Initial list is: ");
        printList(first);

        System.out.println("The list after inserting -1 in the start: ");
        first = insertAtBegin(first, -1);
        printList(first);

        System.out.println("List after inserting 4 at the end: ");
        first = insertAtEnd(first, 4);
        printList(first);

        System.out.println("Enter the position of the node to be inserted: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("List after inserting 100 at position " + n + " is: ");
        first = insertAtGivenPos(first, 100, n);
        printList(first);

        System.out.println("Enter the node after which you want to insert 200: ");
        int data = scan.nextInt();
        System.out.println("List after inserting 200 after node " + data + ": ");
        first = insertAfterSpecifiedNode(first, 200, data);
        printList(first);

        scan.close();
    }
}
