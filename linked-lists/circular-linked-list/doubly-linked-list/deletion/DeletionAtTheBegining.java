/**
 * Program to delete the first node in a circular doubly linked list.
 * 
 * Time Complexity: O(1)
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

public class DeletionAtTheBegining {

    public static Node deleteAtBegin(Node first) {
        if(first == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // Case when there is only one node in the list
        if(first.next == first) {
            return null; // The list becomes empty after deletion.
        }

        // Adjust the pointers of the next and previous nodes.
        first.next.prev = first.prev;
        first.prev.next = first.next;

        // Update the `first` pointer to the new first node
        first = first.next;

        return first;
    }
    
    // Method to print the list.
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


        System.out.println("List after deleting the first node: ");
        first = deleteAtBegin(first);
        printList(first);
    }
}
