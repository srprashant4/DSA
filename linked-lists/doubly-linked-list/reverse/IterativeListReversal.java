/**
 * This is a program to reverse the doubly linked list using Expected Approach (Using Iteration).
 * 
 * The idea is to reverse doubly linked list using two pointers for traversing through 
 * the list and swapping the next and previous pointers of every two consecutive nodes.
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

public class IterativeListReversal {

    // Function to reverse a Doubly Linked List using two pointers
    public static Node reverseList(Node head) {

        if(head == null) {
            return null;
        }

        Node currNode = head;
        Node prevNode = null;

        // Traverse the list and reverse the links
        while(currNode != null) {

            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            // Move to the next node in the original list (which is now previous due to reversal)
            currNode = currNode.prev;
        }

        // Update head of Doubly Linked List
        head = prevNode.prev;

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
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        System.out.println("The original list is: ");
        printList(head);

        System.out.println("The list after reversing is: ");
        head = reverseList(head);
        printList(head);
    }
}
