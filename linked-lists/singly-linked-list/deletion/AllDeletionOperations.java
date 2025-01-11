class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class AllDeletionOperations {

    public static Node deleteNodeAtEnd(Node head) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return null;
        }

        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }

    public static Node deleteNodeAtBegin(Node head) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        head = head.next;
        return head;
    }

    public static Node deleteAtGivenPosition(Node head, int pos) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null && pos == 1) {
            return null;
        }

        if(head != null && pos == 1) {
            return head.next;
        }

        if(head.next == null && pos > 1) {
            System.out.println("Invalid position.");
            return null;
        }

        Node curr = head;
        int count = 1;
        while(curr != null) {
            if(count == pos - 1) {
                break;
            }
            count++;
            curr = curr.next;
        }

        if(curr == null || curr.next == null) {
            System.out.println("No Node found at the given position.");
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list is: ");
        printList(head);

        System.out.println("List after deleting the first node: ");
        //head = deleteNodeAtBegin(head);
        printList(head);

        System.out.println("List after deleting the last node: ");
        //head = deleteNodeAtEnd(head);
        printList(head);

        System.out.println("List after deleting a node at position");
        head = deleteAtGivenPosition(head, 6);
        printList(head);
    }
}
