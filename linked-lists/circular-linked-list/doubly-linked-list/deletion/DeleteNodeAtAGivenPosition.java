import java.util.Scanner;

/**
 * Program to delete a node at a given position in the list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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

public class DeleteNodeAtAGivenPosition {

    public static Node deleteAtGivenPos(Node first, int pos) {

        // Case when the list is empty
        if(first == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // Invalid position check
        if(pos <= 0) {
            System.out.println("Invalid position.");
            return first;
        }

        // Case when there is only one node, and we are deleting that node
        if(first.next == first && pos == 1) {
            return null; // List becomes empty after deletion
        }

        // Deleting the first node (head)
        if(pos == 1) {
            first.next.prev = first.prev;
            first.prev.next = first.next; 
            first = first.next;

            return first;
        }

        // Traverse the list to find the node at the given position
        Node curr = first;
        int count = 1;
        do {
            // If we've found the node at the specified position
            if(count == pos - 1) {
                // Update pointers to bypass the current node
                curr.next = curr.next.next;
                curr.next.next.prev = curr;
                return first;
            }

            curr = curr.next;
            count++;
        } while(curr != first);

        // If the position is beyond the length of the list
        System.out.println("Invalid position.");

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

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the position of the node to be deleted.");
        int n = scan.nextInt();

        System.out.println("List after deleting the node at position " + n + ": ");
        first = deleteAtGivenPos(first, n);
        printList(first);

        scan.close();
    }
}
