/**
 * Problem Statement: Given a singly linked list, the task is to find the middle
 * of the linked list. If the number of nodes are even, then there would be two
 * middle nodes, so return the second middle node.
 * 
 * Example:
 * 1) Input: linked list: 1->2->3->4->5
 * Output: 3
 * Explanation: There are 5 nodes in the linked list and there is one middle
 * node whose value is 3.
 * 
 * 
 * 2) Input: linked list = 10 -> 20 -> 30 -> 40 -> 50 -> 60
 * Output: 40
 * Explanation: There are 6 nodes in the linked list, so we have two middle
 * nodes: 30 and 40, but we will return the second middle node which is 40.
 * 
 * Approach: Use Tortoise and Hare Algoritm.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PrintTheMiddleOfALinkedList {

    public static int getMiddleNode(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer.data;
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

        System.out.println("Middle of the linked list is: " + getMiddleNode(head));
    }
}
