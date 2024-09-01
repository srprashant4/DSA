import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class InsertNodeAtSpecifiedPosition {
    Node head;

    public void insertAtPos(int position, int data) {
        Node newNode = new Node(data);

        if(position < 0) {
            System.out.println("Invalid Position !");
            return;
        }

        if(position == 0) {   
            newNode.next = head;
            head = newNode;
        }

        Node currentNode = head;
        int currentPosition = 0;

        while(currentNode != null && currentPosition < (position - 1)) {
            currentNode = currentNode.next;
            currentPosition++;
        }

        System.out.println("Specified position: "+position);
        System.out.println("Current position: "+currentPosition);

        if(currentNode == null) {
            System.out.println("Invalid position, the position exceeds the length of the list.");
            return;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    public void printList() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(" " + currentNode.data);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        InsertNodeAtSpecifiedPosition list = new InsertNodeAtSpecifiedPosition();

        list.head = new Node(100);
        Node secondNode = new Node(200);
        Node thirdNode = new Node(300);

        list.head.next = secondNode;
        secondNode.next = thirdNode;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the position after which you want to add a new node: ");
        int position = scan.nextInt();

        System.out.println("The list before insertion is: ");
        list.printList();

        list.insertAtPos(position, 150);

        System.out.println("The list after insertion is: ");
        list.printList();

        scan.close();
    }
}