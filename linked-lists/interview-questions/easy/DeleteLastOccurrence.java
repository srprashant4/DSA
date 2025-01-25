import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Given a singly linked list and a key, the task is to delete the last
 * occurrence of that key in the linked list.
 * 
 * The idea is to traverse the linked list from beginning to end. While
 * traversing, keep track of last occurrence key node and previous node of that
 * key. After traversing the complete list, delete the last occurrence of that key.
 * 
 * Time Complexity: O(n), Traversing over the linked list of size n. 
 * Auxiliary Space: O(1)
 * 
 */
public class DeleteLastOccurrence {

    public static Node deleteLastOccurrenceFromList(Node head, int k) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null && head.data == k) {
            return null;
        }

        Node curr = head;
        Node last = null;
        Node prevToLast = null;
        Node prev = null;

        // Traverse the list to find the last occurrence
        while(curr != null) {
            if(curr.data == k) {
                last = curr;
                prevToLast = prev;
            }

            prev = curr;
            curr = curr.next;
        }

        // If the key is not found, do nothing
        if (last == null) {
            System.out.println("Element not found.");
            return head;
        }

        // If the last occurrence is the head
        if(last == head) {
            head = head.next;
        }
        else {
            // Remove the last occurrence
            prevToLast.next = last.next;
        }

        return head;
    }

    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("The original list is: ");
        printList(head);

        System.out.println("Enter the element to be deleted: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("List after deleting the given element: ");
        head = deleteLastOccurrenceFromList(head, n);
        printList(head);

        scan.close();
    }
}
