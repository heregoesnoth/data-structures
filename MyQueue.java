class MyQueue {

    static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    Node first;
    Node last;
    int length;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Node peek() {
        return this.first;
    }

    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    public void dequeue() {
        if (this.first == null) {
            return;
        }
        if (this.first == this.last) {
            this.last = null;
        }
        Node current = this.first;
        this.first = this.first.next;
        this.length--;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.peek();
        myQueue.enqueue("Joy");
        myQueue.enqueue("Matt");
        myQueue.enqueue("Pavel");
        System.out.println(myQueue.peek());
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue.peek());
    }
}
