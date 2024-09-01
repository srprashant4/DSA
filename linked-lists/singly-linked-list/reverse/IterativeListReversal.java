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
    
    public static Node reverseList(Node head) {
        if(head == null ){
            System.out.println("head is null !!!");
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        Node next;
        
        while(curr != null) {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        return prev;
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
	    head.next.next = new Node(2);
	    head.next.next.next = new Node(3);
	    
		System.out.println("Initial list is: ");
		printList(head);
		
		System.out.println("List after reversing is: ");
		head = reverseList(head);
		printList(head);
	}
}
