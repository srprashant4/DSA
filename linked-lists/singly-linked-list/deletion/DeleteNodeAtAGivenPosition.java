/**
 * Java program to delete the node from a given position of the list.
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodeAtAGivenPosition {

    public static Node deleteAtPos(Node head, int pos) {

        if(head == null) {
            System.out.println("The list is already empty !!!");
            return null;
        }

        if(pos == 1) {
            return head.next;
        }

        int count = 1;
        Node curr = head;

        while(curr != null) {
            if(count == pos - 1) {
                break;
            }
            count++;
            curr = curr.next;
        }

        if(curr == null || curr.next == null) {
            System.out.println("No node found at the given position");
            return null;
        }

        if(curr.next.next == null) {
            curr.next = null;
            return head;
        }

        curr.next = curr.next.next;

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

        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.println("The original list is: ");
        printList(head);

        System.out.println("The list after deleting a node at position 1: ");
        head = deleteAtPos(head, 1);
        printList(head);
    }
}
