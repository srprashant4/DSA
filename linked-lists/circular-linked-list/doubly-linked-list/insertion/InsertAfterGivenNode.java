/**
 * Program to insert a node after the specified node.
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

public class InsertAfterGivenNode {

    public static Node insertAfterNode(Node first, int data, int givenNodeData) {

        if(first == null) {
            System.out.println("The list is empty.");
            return null;
        }

        Node newNode = new Node(data);
        Node curr = first;

        do {
            if(curr.data == givenNodeData) {
                curr.next.prev = newNode;
                newNode.next = curr.next;
                curr.next = newNode;
                newNode.prev = curr;
                return first;
            }
            curr = curr.next;
        } while(curr != first);

        System.out.println("The specified node not found in the list.");

        return first;
    }
    
    // Method to print the list.
    public static void printList(Node first) {
        if(first == null) {
            return;
        }

        Node curr = first;
        do  {
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

        System.out.println("List after inserting data after node 2: ");
        first = insertAfterNode(first, 100, 3);
        printList(first);
    }
}
