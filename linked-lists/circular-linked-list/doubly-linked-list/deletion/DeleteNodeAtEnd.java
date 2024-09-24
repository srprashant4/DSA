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

public class DeleteNodeAtEnd {

    public static Node deleteAtEnd(Node first) {
        if(first == null) {
            System.out.println("The list is empty.");
            return null;
        }

        if(first.next == first) {
            return null;
        }

        Node lastNode = first.prev;
        Node secondLastNode = lastNode.prev;

        secondLastNode.next = first;
        first.prev = secondLastNode;

        return first;
    }
    
    public static void printList(Node first) {
        if(first == null) {
            return;
        }

        Node curr = first;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while(curr != first);
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        first.next = new Node(1);
        first.next.prev = first;
        first.next.next = new Node(2);
        first.next.next.prev = first.next;
        first.next.next.next = new Node(3);
        first.next.next.next.prev = first.next.next;
        first.next.next.next.next = first;

        first.prev = first.next.next.next;

        System.out.println("The initial list is: ");
        printList(first);


        System.out.println("List after deleting the last node: ");
        first = deleteAtEnd(first);
        printList(first);
    }
}
