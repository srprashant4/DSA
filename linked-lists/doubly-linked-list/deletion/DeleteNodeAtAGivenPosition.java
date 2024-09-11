import java.util.Scanner;

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

    public static Node deleteAtPos(Node head, int pos) {

        // Return null if the list is already empty.
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(pos == 1) {
            // Special case for deleting the head node
            if(head.next != null) {
                head = head.next;
                head.prev = null;
            } 
            else {
                // Only one node in the list, so the list becomes empty
                head = null;
            }
            return head;
        }

        Node curr = head;
        int count = 1;

        // Traverse to the node just before the one to be deleted
        while(curr != null) {
            if(count < pos - 1) {
                break;
            }
            count++;
            curr = curr.next;
        }

        // Invalid position or reached the end of the list
        if(curr == null || curr.next == null) {
            System.out.println("Invalid position.");
            return null;
        }

        // Delete the node at the given position
        if(curr.next.next == null) {
            // If it's the last node
            curr.next.prev = null;
            curr.next = null;
        }
        else {
            // If it's a node in the middle
            curr.next = curr.next.next;
            curr.next.prev = curr; 
        }

        return head;

    }
    
    public static void printList(Node head) {
        while (head != null) {
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

        System.out.println("Enter the position of the node to be deleted: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("List after deleting the node at position " + n + " :");
        head = deleteAtPos(head, n);
        printList(head);

        scan.close();
    }
}
