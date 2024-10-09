/**
 * Given a doubly linked list, reverse the list.
 * 
 * The idea is to reverse doubly linked list using two pointers for traversing
 * through the list and swapping the next and previous pointers of every two
 * consecutive nodes.
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

public class ReverseDoublyLinkedList {

    /**
     * Algorithm:
     * Initially, prevNode is set to NULL and currNode starts at the head.
     * As the list is traversed,
     * Update prevNode to currNode’s prev, prevNode = currNode->prev.
     * Update currNode’s prev pointer to its next node, currNode->prev =
     * currNode->next.
     * Update currNode’s next pointer to prevNode, currNode->next = prevNode.
     * Move currNode to the next node, currNode = currNode->prev.
     * After traversing all the nodes, prevNode will point to the second node of the
     * reversed list, so update the previous pointer of prevNode as the new head of
     * the linked list, head = prevNode->prev and return it.
     * 
     */
    public static Node reverseList(Node head) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return head;
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
    
    // Method to print the list.
    public static void printList(Node head) {
        if(head == null) {
            return;
        }

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

        System.out.println("The initial list is: ");
        printList(head);

        System.out.println("List after reversing is: ");
        head = reverseList(head);
        printList(head);
    }
}
