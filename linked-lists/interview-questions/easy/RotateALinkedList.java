import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RotateALinkedList {

    public static Node rotateLeft(Node head, int k) {
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(head.next == null) {
            return head;
        }

        for(int i = 0; i < k; i++) {
            Node curr = head;

            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = head;
            head = head.next;
            curr.next.next = null;
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
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.println("The initial list is: ");
        printList(head);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of times the list should be rotated: ");
        int k = scan.nextInt();

        System.out.println("List after rotating left " + k + " times: ");
        head = rotateLeft(head, k);
        printList(head);

        scan.close();
    }
}
