/**
 * Program to reverse a doubly circular linked list in an iterative way.
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

    public static Node reverseList(Node first) {
        if(first == null) {
            System.out.println("The list is empty");
            return null;
        }

        Node currNode = first;
        Node prevNode = null;

        // Traverse through the list and swap next and prev for each node
        do {
            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;
            
            // Since we've swapped next and prev, curr.prev moves us forward
            currNode = currNode.prev;

        } while(currNode != first);

        // Adjust the first pointer to point to the new first node (which was the last node)
        first = prevNode.prev;

        return first;
    }
    
    // Method to print the list.
    public static void printList(Node first) {
        if(first == null) {
            return;
        }

        Node curr = first;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while(curr != first);

        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        first.next = new Node(1);
        first.next.prev = first;
        first.next.next = new Node(2);
        first.next.next.prev = first.next;
        first.next.next.next = new Node(3);
        first.next.next.next.prev = first.next.next;
        first.next.next.next.next = first;

        first.prev = first.next.next.next;

        System.out.println("The initial list is: ");
        printList(first);

        System.out.println("The list after reversing the nodes: ");
        first = reverseList(first);
        printList(first);
    }
}
