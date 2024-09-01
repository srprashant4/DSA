/**
 * This program is to search iteratively for an element if it is present in the linked list or not.
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

public class IterativeListSearch {

    /**
     * Method to perform an iterative search on the list.
     * @param head
     * @param element
     * @return
     */
    public static boolean iterativeSearch(Node head, int element) {

        // If the list is empty, return false.
        if(head == null) {
            System.out.println("The list is empty.");
            return false;
        }
        
        Node curr = head;
        while(curr != null) {
            if(curr.data == element) {
                return true;
            }
            curr = curr.next;
        }
        
        return false;
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
	    
		System.out.println("The list elements are: ");
		printList(head);
		
		boolean isPresent = iterativeSearch(head, 3);
		System.out.println("Is the element 3 present in the list: "+ isPresent);
		
		isPresent = iterativeSearch(head, 5);
		System.out.println("Is the element 5 present in the list: "+ isPresent);
    }
}
