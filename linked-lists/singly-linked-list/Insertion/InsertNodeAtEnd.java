/**
 * This is a program to insert a new node at the end of a Linked List
 * 
 * Approach:
 * 1) Create a new node
 * 2) Store the head reference in a temporary variable
 * 3) Set the next pointer of the new node as NULL since it will be the last node
 * 4) If the Linked List is empty, make the new node as the head and return
 * 5) Else traverse till the last node
 * 6) Change the next pointer of the last node to point to the new node
 * 
 * Complexity:
 * Time Complexity: O(N) where N is the length of the linked list
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

class InsertNodeAtEnd {
    Node head;

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        }

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;

    }

    public void printList() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(" " + currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        InsertNodeAtEnd list = new InsertNodeAtEnd();

        list.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        
        list.head.next = secondNode;
        secondNode.next = thirdNode;
        
        list.insertAtEnd(1000);
        list.printList();
    }
}