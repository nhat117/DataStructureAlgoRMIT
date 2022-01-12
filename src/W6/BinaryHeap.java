package W6;

/*
    * this is an implementatiob of binary heap(Min heap)
    * Shape property: a binary heap is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.
Heap property: the key stored in each node is either greater than or equal to (≥) or less than or equal to (≤) the keys in the node's children, according to some total order.
 */
public class BinaryHeap {

    public static void main(String[] args) {
        Heap<W6Integer> heap = new Heap<W6Integer>();
        heap.insert(new W6Integer(10));
        System.out.println(heap);
        heap.insert(new W6Integer(15));
        System.out.println(heap);
        heap.insert(new W6Integer(8));
        System.out.println(heap);
        heap.insert(new W6Integer(9));
        System.out.println(heap);
        heap.insert(new W6Integer(20));
        System.out.println(heap);
        heap.insert(new W6Integer(32));
        System.out.println(heap);
        System.out.println("=====Removing=====");
        while (heap.size() > 0) {
            System.out.println(heap.remove());
        }

    }

    static class Heap<T extends  Comparable> {
        private int size;
        static int MAX_SIZE = 100;
        private T[] items;

        public Heap() {
            this.size = 0;
            items = (T[])new Comparable[MAX_SIZE];
        }

        public int size() {
            return this.size;
        }

        //Heapify
        private void heapifyUp(int i) {
            int parent = (i -1) /2;
            if(parent >= 0 && items[parent].compareTo(items[i])<0) {
                T tmp = items[i];
                items[i] = items[parent];
                items[parent] = tmp;
                heapifyUp(parent);
            }
        }

        //Heapify top down
        private void  heapifyDown(int i) {
            int root = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if( l < size && items[l].compareTo(items[root]) > 0) {
                root = l;
            }
            if(r < size && items[r].compareTo(items[root]) > 0) {
                root = r;
            }

            //If a change necessary
            if(root != i) {
                T tmp = items[i];
                items[i] = items[root];
                items[root] = tmp;
                heapifyDown(i);
            }
        }

        public void insert(T data) {
            items[size] = data;
            size ++;
            heapifyUp(size -1);
        }

        public T remove() {
            if(size == 0) return  null;
            T tmp = items[0];
            items[0] = items[size - 1];
            size --;
            heapifyDown(0);
            return tmp;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(items[i].toString() + " - ");
            }
            return sb.toString();
        }
    }

    static class W6Integer implements Comparable {
        int value;

        public W6Integer(int value) {
            this.value = value;
        }


        @Override
        public int compareTo(Object o) {
            W6Integer other = (W6Integer)o;
            return value - other.value;
        }

        @Override
        public String toString() {
            return "W6Integer{" +
                    "value=" + value +
                    '}';
        }
    }
}
