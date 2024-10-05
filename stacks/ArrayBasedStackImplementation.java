package stacks;

class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize the stack.
    public Stack(int size) {
        this.stackArray = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    // Method to add an element to the stack.
    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = value;
        System.out.println(value + "pushed to the stack.");
    }

    // Method to remove an element from the stack.
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArray[top--];
    }

    // Method to return the top element of the stack
    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        return stackArray[top];
    }

    // Method to check if the stack is full.
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to check if the stack is empty.
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to return the size of the stack.
    public int size() {
        return top + 1;
    }
}

public class ArrayBasedStackImplementation {
    
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("The top element in the stack is: " + stack.peek());
        System.out.println("The size of the stack is: " + stack.size());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        stack.push(50);
        System.out.println("Top element after push: " + stack.peek());

        System.out.println("After inserting another element in the stack: ");
        stack.push(60);
    }
}
