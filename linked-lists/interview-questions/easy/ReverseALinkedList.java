import java.util.Stack;

/**
 * Problem Statement:
 * Given a linked list, the task is to reverse the linked list by changing the
 * links between nodes.
 * 
 * Examples:
 * 
 * 1) Input: Linked List = 1 -> 2 -> 3 -> 4 -> NULL
 *    Output: Reversed Linked List = 4 -> 3 -> 2 -> 1 -> NULL
 * 
 * 2) Input: Linked List = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 *    Output: Reversed Linked List = 5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * 
 * 3) Input: Linked List = NULL
 *    Output: Reversed Linked List = NULL
 * 
 * 4) Input: Linked List = 1->NULL
 *    Output: Reversed Linked List = 1->NULL
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseALinkedList {

    /**
     * Approach-1: Using Iterative approach:
     * 
     * The idea is to reverse the links of all nodes using three pointers:
     * 
     * 
     * prev: pointer to keep track of the previous node
     * curr: pointer to keep track of the current node
     * next: pointer to keep track of the next node
     * Starting from the first node, initialize curr with the head of linked list
     * and next with the next node of curr. Update the next pointer of curr with
     * prev. Finally, move the three pointer by updating prev with curr and curr
     * with next.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node iterativeListReversal(Node head) {

        // If the list is empty, return null.
        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        Node prev = null;
        Node curr = head;
        Node next;

        // Traverse till the end of the list.
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * Approach-2: List reversal using Stack.
     * 
     * The idea is to traverse the linked list and push all nodes except the last
     * node into the stack. Make the last node as the new head of the reversed
     * linked list. Now, start popping the element and append each node to the
     * reversed Linked List. Finally, return the head of the reversed linked list.
     * 
     * Steps:
     * Push all the nodes(values and address) in the stack.
     * 2) Once the nodes are pushed, update the Head pointer to the last node.
     * 3) Start popping the nodes and push them at the end of the linked list in the
     * same order until the stack is empty.
     * 4) Update the next pointer of last node in the stack by NULL.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n), Space is used to store the nodes in the stack.
     * 
     */
    public static Node listReversalUsingStack(Node head) {

        if(head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // If there is only one node in the list, return head.
        if(head.next == null) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node temp = head;

        // Push all the nodes into the stack.
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        if(!stack.isEmpty()) {

            // Set the new head to the last element of the original list.
            head = stack.pop();
            temp = head;
            
            // Pop all the nodes and append to the linked list
            while(!stack.isEmpty()) {

                // Append the top value of stack in list
                temp.next = stack.pop();

                // Move to the next node in the list
                temp = temp.next;
            }

            // Update the next pointer of last node of stack to NULL
            temp.next = null;
            
        }

        return head;
    }
    
    // Method to print the list.
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

        // System.out.println("List after reversing in an iterative approach: ");
        // Node head1 = iterativeListReversal(head);
        // printList(head1);

        System.out.println("List after reversing using a stack: ");
        Node head2 = listReversalUsingStack(head);
        printList(head2);
    }
}
