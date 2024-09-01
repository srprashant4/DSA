/**
 * Java program to delete the last node from the list.
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

public class DeleteNodeAtEnd {

    public static Node deleteAtEnd(Node head) {

        if(head == null) {
            System.out.println("The list is already empty !!!");
            return null;
        }

        if(head.next == null) {
            return null;
        }

        if(head.next.next == null) {
            head.next = null;
            return head;
        }

        Node curr = head;
        while(curr != null) {
            if(curr.next.next == null) {
                break;
            }
            
            curr = curr.next;
        }

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
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.println("The original list is: ");
        printList(head);

        System.out.println("List after deleting the last node: ");
        head = deleteAtEnd(head);
        printList(head);
    }
}
