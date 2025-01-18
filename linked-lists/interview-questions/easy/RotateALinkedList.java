import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RotateALinkedList {

    /**
     * [Naive Approach] Shifting head node to the end k times – O(n * k) Time and O(1) Space
     * @param head
     * @param k
     * @return head
     */
    public static Node rotateLeft(Node head, int k) {
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return head;
        }

        for(int i = 0; i < k; i++) {
            Node curr = head;

            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = head;
            head = head.next;
            curr.next.next = null;
        }

        return head;
    }

    /**
     * [Expected Approach] By changing pointer of kth node – O(n) Time and O(1)
     * Space
     * 
     * The idea is to first convert the linked list to circular linked list by
     * updating the next pointer of last node to the head of linked list. Then,
     * traverse to the kth node and update the head of the linked list to the
     * (k+1)th node. Finally, break the loop by updating the next pointer of kth
     * node to NULL..
     * 
     * @param head
     */
    public static Node rotateList2(Node head, int k) {

        // If the linked list is empty or no rotations are
        // needed, then return the original linked list
        if (k == 0 || head == null)
            return head;

        Node curr = head;
        int len = 1;
      
        // Find the length of linked list
        while (curr.next != null) {
            curr = curr.next;
            len += 1;
        }

        // Modulo k with length of linked list to handle
        // large values of k
        k %= len;
      
        if (k == 0)
            return head;
      
          // Make the linked list circular
        curr.next = head;

        // Traverse the linked list to find the kth node
        curr = head;
        for (int i = 1; i < k; i++)
            curr = curr.next;

        // Update the (k + 1)th node as the new head
        head = curr.next;
      
        // Break the loop by updating next pointer of kth node
        curr.next = null;
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

        System.out.println("The initial list is: ");
        printList(head);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of times the list should be rotated: ");
        int k = scan.nextInt();

        // System.out.println("List after rotating left " + k + " times: ");
        // head = rotateLeft(head, k);
        // printList(head);

        System.out.println("List after rotating left " + k + " times using optimal approach: ");
        head = rotateList2(head, k);
        printList(head);

        scan.close();
    }
}
