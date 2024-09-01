/**
 * Approach:
 * To insert a node after a given node in a Linked List, we need to:
 * 
 * 1) Check if the given node exists or not (given node {prevNode} should not be null).
 * 2) If it do not exists, terminate the process.
 * 3) If the given node exists, 
 *    a) Make the element to be inserted as a new node.
 *    b) Change the next pointer of given node to the new node.
 *    c) Now shift the original next pointer of given node to the next pointer of new node.
 * 
 * Time Complexity: O(1)
 * Auxiliary Space: O(1)
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class InsertNodeAtAgivenPosition {
    Node head;

    public void insertAfterNode(Node prevNode, int data){
        if(prevNode == null) {
            System.out.println("The previous node cannot be NULL");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void printList() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        InsertNodeAtAgivenPosition list = new InsertNodeAtAgivenPosition();

        list.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(5);

        list.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        list.insertAfterNode(thirdNode, 4);

        list.printList();
    }
}