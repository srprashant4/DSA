/**
 * This is a java code to demonstrate how to add a new node at various positions of a doubly linkedlist.
 * 
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

public class AllInsertionOperations {

    public static Node insertAtBegin(Node head, int data) {
        Node newNode = new Node(data);

        while(head == null) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;

        return newNode;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        if(head == null) {
            return newNode;
        }

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        newNode.prev = curr;
        curr.next = newNode;

        return head;
    }

    public static Node insertAtPos(Node head, int data, int pos) {
        Node newNode = new Node(data);

        if(head == null && pos == 1) {
            return newNode;
        }

        if(head == null && pos > 1) {
            System.out.println("Invalid position.");
            return null;
        }

        if(head != null && pos == 1) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        Node curr = head;
        int count = 1;
        while(curr != null) {
            if(count == pos - 1) {
                break;
            }
            curr = curr.next;
            count++;
        }

        if(curr == null) {
            System.out.println("Invalid position.");
            return null;
        }

        if(curr.next == null) {
            curr.next = newNode;
            newNode.prev = curr;
        } else {
            newNode.next = curr.next;
            curr.next = newNode;
            newNode.prev = curr;
        }

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

        System.out.println("List after inserting -1 in the begining: ");
        head = insertAtBegin(head, -1);
        printList(head);

        System.out.println("List after inserting 4 at the end: ");
        head = insertAtEnd(head, 4);
        printList(head);

        System.out.println("List after inserting 100 at position 3: ");
        head = insertAtPos(head, 100, 3);
        printList(head);
    }
}
