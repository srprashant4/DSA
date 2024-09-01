/**
 * This program is to reverse the linked list in an iterative approach.
 * 
 * Complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 */
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IterativeListReversal {
    
    /**
     * Method to reverse the list in an iterative approach.
     * @param head
     * @return head
     */
    public static Node reverseList(Node head) {

        // If the list is empty, return null.
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }
        
        /**
         * Maintain three pointers prev, curr and next.
         * The idea is to reverse the links of all nodes using three pointers:
         * 
         * prev: pointer to keep track of the previous node
         * curr: pointer to keep track of the current node
         * next: pointer to keep track of the next node
         * Starting from the first node, initialize curr with the head of linked list
         * and next with the next node of curr. Update the next pointer of curr with
         * prev. Finally, move the three pointer by updating prev with curr and curr
         * with next.
         */
        Node prev = null;
        Node curr = head;
        Node next;
        
        // Traverse till the curr points to null.
        while(curr != null) {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }

        // return the prev pointer.
        return prev;
    }
    
    /**
     * Method to print the list.
     * @param head
     */
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
	    
		System.out.println("Initial list is: ");
		printList(head);
		
		System.out.println("List after reversing is: ");
		head = reverseList(head);
		printList(head);
	}
}
