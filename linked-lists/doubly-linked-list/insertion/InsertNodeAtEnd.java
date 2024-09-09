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

public class InsertNodeAtEnd {

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
        newNode.prev = curr;

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

        System.out.println("List after inserting 4 at the end: ");
        head = insertAtEnd(head, 4);
        printList(head);
    }
}
