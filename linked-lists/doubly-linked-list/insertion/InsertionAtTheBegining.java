/**
 * This program demonstrates the insertion of a node at the begining of a doubly linked list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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

public class InsertionAtTheBegining {

    public static Node insertAtBegin(Node head, int data) {
        Node newNode = new Node(data);

        if(head == null) {
            return newNode;
        }

        head.prev = newNode;
        newNode.next = head;

        return newNode;
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
        Node second = new Node(1);
        Node third = new Node(2);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("The initial list is: ");
        printList(head);

        System.out.println("After inserting -1 at the begining: ");
        head = insertAtBegin(head, -1);
        printList(head);
    }
}
