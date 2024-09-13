/**
 * This is a program to reverse the doubly linked list using Naive Approach (Using Recursion).
 * 
 * The idea is to use recursion to reverse the links in the doubly linked list. 
 * The recursive function will traverse the list and reverse the links while backtracking.
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

public class RecursiveListReversal {

    // Recursive function to reverse a doubly linked list
    public static Node reverseList(Node curr) {

        // Base case: If list is empty or we reach the end of the list
        if(curr == null) {
            return null;
        }

        // Swap the next and prev pointers
        Node temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;

        // If prev is null after swap, this is the new head
        if(curr.prev == null) {
            return curr;
        }

        // Recurse for the next node
        return reverseList(curr.prev);
    }
    
    // Method to print the linked list.
    public static void printList(Node head) {
        while(head != null) {
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

        System.out.println("The original list is: ");
        printList(head);

        System.out.println("List after reversal is: ");
        head = reverseList(head);
        printList(head);
    }
}
