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

public class InsertNodeAtSpecifiedPosition {

    public static Node insertAtGivenPosition(Node head, int data, int pos) {
        Node newNode = new Node(data);

        if(head == null && pos == 1) {
            return newNode;
        }

        if(head == null && pos > 1) {
            System.out.println("Specified position does not exist in the list.");
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
            count++;
            curr = curr.next;
        }

        if(curr == null) {
            System.out.println("Invalid position.");
            return null;
        } 

        // Handle insertion at the end of the list.
        if(curr.next == null) {
            curr.next = newNode;
            newNode.prev = curr;
        } else {
            newNode.next = curr.next;
            curr.next.prev = newNode;
            newNode.prev = curr;
            curr.next = newNode;
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

        System.out.println("The list after inserting a new node at position 3 is: ");
        head = insertAtGivenPosition(head, 100, 5);
        printList(head);
    }
}
