import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class GetNthNodeFromEnd {

    /**
     * Native approch: Finding the length of list – Two Pass – O(M) Time and O(1)
     * Space.
     * 
     * The idea is to count the number of nodes in linked list in the first pass,
     * say len. In the second pass, return the (len – n + 1)th nodes from beginning
     * of the Linked List.
     * 
     * @param head
     * @param n
     * @return node data
     */
    public static int findNthFromLast(Node head, int n) {

        if(head == null) {
            System.out.println("The list is empty.");
            return -1;
        }

        int len = 0;
        Node curr = head;

        // Find the length of the list.
        while(curr != null) {
            curr = curr.next;
            len++;
        }

        if(len < n) {
            System.out.println("Invalid position.");
            return -1;
        }

        curr = head;
        for(int i = 1; i < len - n + 1; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    /**
     * Using Two Pointers – One Pass – O(M) Time and O(1) Space.
     * 
     * The idea is to maintain two pointers, say main_ptr and ref_ptr point to the
     * head of Linked List and move ref_ptr to the Nth node from the head to ensure
     * that the distance between main_ptr and ref_ptr is (N – 1). Now, move both the
     * pointers simultaneously until ref_ptr reaches the last node. Since the
     * distance between main_ptr and ref_ptr is (N – 1), so when ref_ptr will reach
     * the last node, main_ptr will reach Nth node from the end of Linked List.
     * Return the value of node pointed by main_ptr.
     * 
     * @param head
     * @param n
     * @return node data
     */
    public static int nthFromEnd(Node head, int n) {

        // Create two pointers main_ptr and ref_ptr
        // initially pointing to head.
        Node main_ptr = head;
        Node ref_ptr = head;

        // Move ref_ptr to the N-th node from beginning.
        for(int i = 1; i < n; i++) {
            ref_ptr = ref_ptr.next;

            if(ref_ptr == null) {
                System.out.println("Invalid position.");
                return -1;
            }
        }

        // Move ref_ptr and main_ptr by one node until
        // ref_ptr reaches last node of the list.
        while (ref_ptr.next != null) {
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }

        return main_ptr.data;
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
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.println("The list is: ");
        printList(head);

        System.out.println("Enter the nth index from end: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("Nth element from end using native approach is: " + findNthFromLast(head, n));

        System.out.println("Nth element from end using optimized approach is: " + nthFromEnd(head, n));

        scan.close();
    }
}
