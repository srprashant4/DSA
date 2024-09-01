/**
 * Java program to delete the node from the begining of the list.
 * Time Complexity: O(1)
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

public class DeletionAtTheBegining {

    public static Node deleteAtBegin(Node head) {
        if(head == null) {
            System.out.println("The list is empty !!!");
            return null;
        }

        head = head.next;

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

        System.out.println("List after deleting the first node: ");
        head = deleteAtBegin(head);
        printList(head);
    }

}
