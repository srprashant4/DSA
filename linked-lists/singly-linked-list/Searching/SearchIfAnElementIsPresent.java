/**
 * This program is to search for an element if it is present in the linked list or not.
 * 
 * Complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SearchIfAnElementIsPresent {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean search(int data) {
        Node currentNode = head;

        while(currentNode.next != null) {
            if(currentNode.data == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void printList() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SearchIfAnElementIsPresent list = new SearchIfAnElementIsPresent();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("The list is: ");
        list.printList();

        if(list.search(5)){
            System.out.println("Element 5 has been found in the list.");
        } else {
            System.out.println("Element 5 is not found in the list.");
        }

        if(list.search(6)){
            System.out.println("Element 6 has been found in the list.");
        } else {
            System.out.println("Element 6 is not found in the list.");
        }

    }
}