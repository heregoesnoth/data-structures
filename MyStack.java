public class MyStack {

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node top;
    Node bottom;
    int length;

    public MyStack() {
        this.top = null;
        this.length = 0;
    }

    public Node peek() {
        return this.top;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            Node hold = this.top;
            this.top = newNode;
            this.top.next = hold;
        }
        this.length++;
    }

    public Node pop() {
        if (this.top == null) {
            return null;
        }

        if (this.top == this.bottom) {
            this.bottom = null;
        }

        Node hold = this.top;
        this.top = this.top.next;
        this.length--;
        return hold;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.peek();
        myStack.push(5);
        myStack.push(10);
        myStack.push(15);
        myStack.pop();
        System.out.println(myStack.peek());;
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack);
    }
}
