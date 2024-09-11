import java.util.Scanner;

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

public class AllDeletionOperations {

    public static Node deleteAtBegin(Node head) {
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }

    public static Node deleteAtEnd(Node head) {
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return null;
        }

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;
        curr.prev = null;

        return head;
    }

    public static Node deleteAtGivenPos(Node head, int pos) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null && pos == 1) {
            return null;
        }

        if(head != null && pos == 1) {
            head = head.next;
            head.prev = null;
            return head;
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
            System.out.println("Invalid position.");
            return null;
        }

        if(curr.next.next == null) {
            curr.next.prev = null;
            curr.next = null;
            return head;
        }

        curr.next = curr.next.next;
        curr.next.prev = curr;

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
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        System.out.println("The initial list is: ");
        printList(head);
        
        // System.out.println("List after deleting the first node: ");
        // head = deleteAtBegin(head);
        // printList(head);

        // System.out.println("List after deleting the last node: ");
        // head = deleteAtEnd(head);
        // printList(head);

        System.out.println("Enter the position at which the node should be deleted.");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("List after deleting the node at position " + n +":");
        head = deleteAtGivenPos(head, n);
        printList(head);

        scan.close();
    }
}
