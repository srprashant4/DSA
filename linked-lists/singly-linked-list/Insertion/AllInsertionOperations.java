/**
 * This is a java code to demonstrate how to add a new node at various positions of a linkedlist.
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

public class AllInsertionOperations {

    /**
     * Complexity Analysis:
     * 1) Time Complexity: O(1).
     * 2) Space Complxity: O(1).
     * 
     * @param head
     * @param data
     * @return head
     */
    public static Node insertAtBegin(Node head, int data) {
        
        Node newNode = new Node(data);

        // Return the new node created if the list is empty.
        if(head == null) {
            return newNode;
        }

        // Place the new node at the begining and make it the new head.
        newNode.next = head;
        head = newNode;

        return head;
    }

    /**
     * Complexity Analysis:
     * 1) Time Complexity: O(n).
     * 2) Space Complxity: O(1).
     * 
     * @param head
     * @param data
     * @return head
     */
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        // Return the new node created if the list is empty.
        if(head == null) {
            return newNode;
        }

        Node curr = head;

        // Traverse till the end of the list.
        while(curr.next != null) {
            curr = curr.next;
        }

        // Attach the new node to the last node of the list.
        curr.next = newNode;

        return head;
    }

    /**
     * Complexity Analysis:
     * 1) Time Complexity: O(n).
     * 2) Space Complxity: O(1).
     * 
     * @param head
     * @param data
     * @param pos
     * @return head
     */
    public static Node insertAtGivenPos(Node head, int data, int pos) {
        Node newNode = new Node(data);

        // If the list is empty and the position of insertion is 1, return the new node.
        if(head == null && pos == 1) {
            return newNode;
        }

        // If the list is empty and the position of insertion is not 1, return the null.
        if(head == null && pos != 1) {
            System.out.println("Invalid position.");
            return null;
        }

        // If the list is not empty and the position of insertion is not 1, attach the
        // new node at the begining and return the list with new node as it's head.
        if(head != null && pos == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node curr = head;
        int count = 1;

        // Traverse till the specified position.
        while(curr != null) {
            if(count == pos - 1) {
                break;
            }
            count++;
            curr = curr.next;
        }

        // Return null if the position specified is invalid.
        if(curr == null) {
            System.out.println("Invalid position.");
            return null;
        }

        // Attach the new node at the given position.
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    /**
     * Complexity Analysis:
     * 1) Time Complexity: O(n).
     * 2) Space Complxity: O(1).
     * 
     * @param head
     * @param data
     * @param nodeData
     * @return head
     */
    public static Node insertAfterGivenNode(Node head, int data, int nodeData) {
        Node newNode = new Node(data);

        // If the list is empty, return null.
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        Node curr = head;

        // Traverse till the specified node.
        while(curr != null) {
            if(curr.data == nodeData) {
                break;
            }
            curr = curr.next;
        }

        // If the specified node is not found, return null.
        if(curr == null) {
            System.out.println("No such node found.");
            return null;
        }

        // Insert the new node after the specified node.
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    /**
     * Method to print the linked list.
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

        System.out.println("Initial List is: ");
        printList(head);

        System.out.println("After inserting a node at the begining: ");
        head = insertAtBegin(head, -1);
        printList(head);

        System.out.println("After inserting a node at the end: ");
        head = insertAtEnd(head, 4);
        printList(head);

        System.out.println("After inserting a node at position 1: ");
        head = insertAtGivenPos(head, 100, 1);
        printList(head);

        System.out.println("After inserting a node after the node 4: ");
        head = insertAfterGivenNode(head, 5, 4);
        printList(head);
    }
}
