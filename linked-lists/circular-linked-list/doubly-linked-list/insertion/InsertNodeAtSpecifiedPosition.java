import java.util.Scanner;

/**
 * Program to insert a new node at the specified position in a doubly circular linked list.
 * 
 * Time Complexity: O(n)
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

public class InsertNodeAtSpecifiedPosition {

    public static Node insertAtGivenPos(Node first, int data, int pos) {
        Node newNode = new Node(data);

        // Invalid position check.
        if(pos <= 0) {
            System.out.println("Invalid position.");
            return first;
        }

        // If the list is empty and position is 1, return the newly created node.
        if(first == null && pos == 1) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }

        // If the list is empty and the specified position is greater than 1, return invalid position.
        if(first == null && pos > 1) {
            System.out.println("Invalid position.");
            return first;
        }

        // If position is the starting of the list which is not empty.
        if(first != null && pos == 1) {
            first.prev.next = newNode;
            newNode.prev = first.prev;
            newNode.next = first;
            first.prev = newNode;
            
            return newNode;
        }

        // If it is any other position other than 1, traverse till that position.
        Node curr = first;
        int count = 1;
        while(curr.next != first) {
            if(count == pos - 1) {
                break;
            }
            count++;
            curr = curr.next;
        }

        // If the specified position does not exist in the list.
        if(count < pos - 1) {
            System.out.println("Invalid position.");
            return first;
        }

        // If the position exists, insert it in the list.
        curr.next.prev = newNode;
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next = newNode;

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

        System.out.println("Initial list is: ");
        printList(first);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the position: ");
        int n = scan.nextInt();

        System.out.println("List after inserting 100 at position " + n + " :");
        first = insertAtGivenPos(first, 100, n);
        printList(first);

        scan.close();
    }
}
