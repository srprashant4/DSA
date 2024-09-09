/**
 * This program demonstrates the forward and backward traversal techniques in a doubly linked list.
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
        this.next = prev;
    }
}

public class DoublyLinkedListTraversal {

    public static void forwardTraversal(Node head) {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void backwardsTraversal(Node tail) {
        Node curr = tail;

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("Forward traversal in doubly linked list: ");
        forwardTraversal(head);

        System.out.println("Backwards traversal in doubly linked list: ");
        backwardsTraversal(third);
    }
}
