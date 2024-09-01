import java.util.Scanner;

/**
 * Program to find the Nth node of a list using iterative and recursive methods.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class GetNthNode {

    /**
     * Iterative approach to find the Nth node of the list.
     * Time Complexity : O(n), where n is the nth node of linked list.
     * Auxiliary Space: O(1)
     */
    public static int getNthNodeIterative(Node head, int index) {

        if(head == null) {
            System.out.println("The list is empty.");
            return -1;
        }

        Node curr = head;
        int count = 1;
        while(curr != null) {
            if(count == index) {
                return curr.data;
            }
            count++;
            curr = curr.next;
        }

        return -1;
    }

    /**
     * Recursive approach to find the Nth node of the list.
     * Time Complexity : O(n), where n is the nth node of linked list.
     * Auxiliary Space: O(n), for recursive call stack.
     */
    public static int getNthNodeRecursive(Node head, int index) {

        if(head == null) {
            System.out.println("The list is empty.");
            return -1;
        }

        if(index == 1) {
            return head.data;
        }

        // recursively decrease n and increase head to next pointer.
        return getNthNodeIterative(head.next, index - 1);
    }

    // Print the list.
    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        // Create a static list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.println("The list is: ");
        printList(head);

        System.out.println("Enter the index: ");
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();

        System.out.println("The node present at the provided index using iterative approach is: "
                + getNthNodeIterative(head, index));

        System.out.println("The node present at the provided index using recursive approach is: "
                + getNthNodeRecursive(head, index));

        scan.close();
    }
}
