package W4;

public class LinkedListStack <T>{
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public LinkedListStack() {
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Basic Stack operation
    public boolean pop() {
        //Make sure the stack is not empty
        if(isEmpty()) return false;

        //Advance head
        head = head.next;
        size -- ;
        return true;
    }

    public boolean push(T data) {
        Node <T> node = new Node<>(data);
        if(!isEmpty()) {
            node.next = head;
        }
        this.head = node;
        size ++;
        return true;
    }

    public T peek() {
        //Make sure the stack is not Empty
        if(isEmpty()) return null;
        return this.head.data;
    }

    public static void main(String[] args) {
        LinkedListStack<String> list = new LinkedListStack<String>();
        list.push("hello");
        list.push("world");
        System.out.println(list.peek());
        list.pop();
        list.push("from RMIT");
        System.out.println(list.peek());
        list.pop();
        System.out.println(list.peek());
        list.pop();
        System.out.println(list.peek());
        list.pop();
    }
}
