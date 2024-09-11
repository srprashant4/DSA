/**
 * Java Program to delete a node from the end of a Doubly Linked List.
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

public class DeleteNodeAtEnd {

    public static Node deleteAtEnd(Node head) {

        // If the list is already empty, return null.
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // If there is only one node, return null.
        if(head.next == null) {
            return null;
        }

        // Traverse till the last node.
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Set the next pointer of the 2nd last node as null.
        curr.prev.next = null;

        // Set the prev pointer of the last node as null.
        curr.prev = null;

        return head;
    }
    
    // Method to print the list.
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
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        System.out.println("The initial list is: ");
        printList(head);

        System.out.println("List after deleting the last node: ");
        head = deleteAtEnd(head);
        printList(head);
    }
}
