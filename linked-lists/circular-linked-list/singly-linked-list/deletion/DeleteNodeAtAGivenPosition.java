import java.util.Scanner;

/**
 * Program to delete the node at the specified position in a circular linked list.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodeAtAGivenPosition {

    // Method to delete the node at the specified position.
    public static Node deleteAtGivenPos(Node last, int pos) {

        if(last == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // Case 1: Deleting the only node in the list
        if(last.next == last && pos == 1) {
            return null; // The list becomes empty after deletion
        }
        
        // Case 2: Invalid position check
        if(pos <= 0) {
            System.out.println("Invalid position.");
            return last;
        }

        Node temp = last.next;

        // Case 3: Deleting the first node (special case)
        if(pos == 1) {

            // If only one node was there
            if(last.next == last) {
                last = null;
            }
            else {
                last.next = last.next.next; // Update last.next to the new first node
            }

            return last;
        }

        // Case 4: Deleting any other node
        int count = 1;
        while(temp != last) {
            if(count == pos - 1) {
                break;
            }
            temp = temp.next;
            count++;
        }

        if(temp == last || temp.next == last.next) {
            System.out.println("Invalid position.");
            return null;
        }

        temp.next = temp.next.next; // Bypass the node to be deleted

        return last;
    }
    
    // Method to print the list.
    public static void printList(Node last) {
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

        System.out.println("The initial list is: ");
        printList(last);

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Enter the position: ");
            int n = scan.nextInt();
            String str;

            System.out.println("List after deleting the node at position " + "n: ");
            last = deleteAtGivenPos(last, n);
            printList(last);

            System.out.println("Want to continue (y/n): ");
            str = scan.next();

            if(str.equalsIgnoreCase("N")) {
                break;
            }
        }


        scan.close();
    }
}
