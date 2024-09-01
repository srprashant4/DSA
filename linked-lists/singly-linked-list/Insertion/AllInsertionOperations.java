class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AllInsertionOperations {

    public static Node insertAtBegin(Node head, int data) {
        
        Node newNode = new Node(data);

        if(head == null) {
            return newNode;
        }

        newNode.next = head;
        head = newNode;

        return head;
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

        curr.next = newNode;
        return head;
    }

    public static Node insertAtGivenPos(Node head, int data, int pos) {
        Node newNode = new Node(data);

        if(head == null && pos == 1) {
            return newNode;
        }

        if(head == null && pos != 1) {
            System.out.println("Invalid position !!!");
            return null;
        }

        if(head != null && pos == 1) {
            newNode.next = head;
            head = newNode;
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

        if(curr == null) {
            System.out.println("Invalid position !!!");
            return null;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    public static Node insertAfterGivenNode(Node head, int data, int nodeData) {
        Node newNode = new Node(data);

        if(head == null) {
            System.out.println("Invalid entry !!!");
            return null;
        }

        Node curr = head;

        while(curr != null) {
            if(curr.data == nodeData) {
                break;
            }
            curr = curr.next;
        }

        if(curr == null) {
            System.out.println("No such element found !!!");
            return null;
        }

        newNode.next = curr.next;
        curr.next = newNode;

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
