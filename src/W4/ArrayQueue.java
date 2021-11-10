package W4;
/*
Implementation of array queue
 */
public class ArrayQueue <T> {
    private int size;
    private static int MAX_SIZE = 100;
    private  T[] arr;

    public ArrayQueue() {
        size = 0;
        arr = (T[]) new Object[MAX_SIZE];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Boolean enQueue(T data) {
        //Make sure the queue is available
        if(size < MAX_SIZE) {
            arr[size] = data;
            size ++;
            return true;
        }
        return  false;
    }

    public boolean deQueue() {
        //Make sure the queue is not empty
        if(isEmpty()) return false;

        //Shift element
        for (int i = 0; i < size  - 1; i ++) {
            arr[i] = arr[i + 1];
        }
        size --;
        arr[size] = null;
        return true;
    }

    public T peekFront() {
        //Ensure the queue is not Empty
        if(isEmpty()) return null;
        return arr[0];
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.enQueue(20);
        queue.enQueue(33);
        System.out.println(queue.peekFront());
        queue.deQueue();
        queue.enQueue(7);
        System.out.println(queue.peekFront());
        queue.deQueue();
        System.out.println(queue.peekFront());
        queue.deQueue();
        System.out.println(queue.peekFront());
        queue.deQueue();
    }
}
