import java.util.Scanner;

/**
 * Program to insert the node in a circular linked list at a specified position.
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertNodeAtSpecifiedPosition {

    // Method to add a node at the specified position.
    public static Node insertAtSpecificPos(Node last, int data, int pos) {
        
        Node newNode = new Node(data);

        // Case 1: Empty list, inserting at position 1
        if(last == null && pos == 1) {
            newNode.next = newNode; // The new node points to itself, making it circular
            return newNode; // The new node becomes the last node
        }

        // Case 2: Invalid position (list is empty but pos > 1, or pos < 1)
        if((last == null && pos > 1) || pos < 0) {
            System.out.println("Invalid position.");
            return last; // Return the unchanged list
        }

        // Case 3: Inserting at position 1 (beginning of the list)
        if(last != null && pos == 1) {
            newNode.next = last.next; // Insert newNode after last and before the current first node
            last.next = newNode;
            return last; // The last node doesn't change
        }

        // Case 4: Inserting at a position other than the first
        Node temp = last.next; // Start from the first node
        int count = 1;

        // Traverse the list to find the position
        while(temp != last) {
            if(count == pos - 1) {
                break;
            }
            count++;
            temp = temp.next;
        }

        // If temp is the last node, we are inserting at the end
        if(temp == last && pos - 1 == count) {
            newNode.next = last.next; // Insert the new node after the last node
            last.next = newNode; 
            
            return newNode; // The new node becomes the last node
        }
        // If we traversed and didn't find the position, the position is invalid
        else if(temp == last && pos - 1 != count) {
            System.out.println("Invalid position.");
            return last;
        }

        // Case 5: Insert the node in the middle
        newNode.next = temp.next; // Insert the new node at the found position
        temp.next = newNode;

        return last; // The last node doesn't change
    }
    
    // Method to print the list.
    public static void printList(Node last) {
        if(last == null) {
            System.out.println("The list is empty.");
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

        System.out.println("Enter the position: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("List after inserting 100 at position " + n + ": ");
        last = insertAtSpecificPos(last, 100, n);
        printList(last);

        scan.close();
    }
}
