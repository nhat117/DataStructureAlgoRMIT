package W4;

public class LinkedListQueue <T>{
    //Container
    static class Node<T> {
        T data;
        Node <T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node <T> head;

    public LinkedListQueue() {
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Basic Queue operation
    public boolean enQueue(T item) {
        Node <T> next = new Node<>(item);
        next.next = head;
        head = next;
        size ++ ;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        if(size == 1) {
            head = null;
            size = 0;
            return true;
        }

        Node<T> prev = head;
        Node<T> nxt = prev.next;
        while (nxt.next != null) {
            prev = nxt;
            nxt = nxt.next;
        }

        prev.next = null;
        size --;
        return true;
    }

    public T peekFront(){
        if(isEmpty()) return null;
        Node<T> nxt = head;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        return nxt.data;
    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enQueue("hello");
        queue.enQueue("world");
        queue.enQueue("from");
        queue.enQueue("RMIT");
        while (!queue.isEmpty()) {
            System.out.println(queue.peekFront());
            queue.deQueue();
        }
    }
}
