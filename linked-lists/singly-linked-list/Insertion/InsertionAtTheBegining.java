/**
 * This is a java code to demonstrate how to add a new node at the start of a linkedlist.
 * 
 * Approach:
 * 1) Make the first node of Linked List linked to the new node
 * 2) Remove the head from the original first node of Linked List
 * 3) Make the new node as the Head of the Linked List.
 * 
 * Complexity Analysis:
 * 1) Time Complexity: O(1), We have a pointer to the head and we can directly attach a node and change the pointer. 
 * So the Time complexity of inserting a node at the head position is O(1) as it does a constant amount of work.
 * 2) Space Complxity: O(1)
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class InsertionAtTheBegining {
    Node head;

    //Method to insert a new node at the start of the linked list.
    void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Method to print the list
    void printList() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InsertionAtTheBegining linkedList = new InsertionAtTheBegining();

        //Insert the nodes at start
        linkedList.insertAtStart(3);
        linkedList.insertAtStart(7);
        linkedList.insertAtStart(9);

        //Print the list
        System.out.println("Linked list is: ");
        linkedList.printList();
    }
}