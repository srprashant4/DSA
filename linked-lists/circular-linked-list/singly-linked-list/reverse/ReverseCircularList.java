/**
 * This program is incomplete.
 */

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseCircularList {

    public static Node reverseList(Node last) {
        if(last == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(last.next == last) {
            return last;
        }

        Node head = last.next;
        Node prev = last;
        Node current = head;
        Node next = last;

        // Reverse the links in the circular linked list
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while(current != head);

        // Adjust the last node's next pointer.
        last.next = prev;

        return prev;
    }
    
    public static void printList(Node last) {

        if(last == null) {
            return;
        }

        Node head = last.next;
        while(true) {
            System.out.print(head.data + " ");
            head = head.next;

            if(head == last.next) break;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);
        Node last = new Node(3);

        first.next = second;
        second.next = third;
        third.next = last;
        last.next = first;

        System.out.println("The initial list is: ");
        printList(last);

        System.out.println("List after reversing is: ");
        last = reverseList(last);
        printList(last);
    }
}
