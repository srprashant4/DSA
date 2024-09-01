/**
 * This program is to search recursively for an element if it is present in the linked list or not.
 * 
 * Complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(n), Extra space is used in the recursion call stack.
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

public class RecursiveListSearch {

    public static boolean recursiveSearch(Node head, int element) {
        
        // Base case:
        if(head == null) {
            return false;
        }
        
        if(head.data == element) {
            return true;
        }
        
        return recursiveSearch(head.next, element);
            
    }
    
    public static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
	    Node head = new Node(0);
	    head.next = new Node(1);
	    head.next.next = new Node(2);
	    head.next.next.next = new Node(3);
	    
		System.out.println("The list elements are: ");
		printList(head);
		
		boolean isPresent = recursiveSearch(head, 2);
		System.out.println("Is the element 2 present in the list: "+isPresent);
		
		isPresent = recursiveSearch(head, 8);
		System.out.println("Is the element 8 present in the list: "+isPresent);
	}
}
