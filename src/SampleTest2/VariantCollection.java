package SampleTest2;
//An implementation of binary tree

public class VariantCollection {
    static final int SIZE =  100;
    Node root;
    //Client code
    public static void main(String[] args) {
        VariantCollection col = new VariantCollection();
        col.addVariant(new CovidVariant("Alpha", "210201A"));
        col.addVariant(new CovidVariant("Delta", "210311D"));
        col.addVariant(new CovidVariant("Beta", "210311A"));
        col.addVariant(new CovidVariant("Omicron", "211120D"));
        col.search("210311A"); // return the Beta variant
        System.out.println(col.previous("211120D")); // return the Delta variant
//        System.out.println(variant1IsLarger(new CovidVariant("Beta","210311A"),new CovidVariant("Alpha","210201A")));
    }

    //Utility function
    class Node {
        CovidVariant value;
        Node left, right;

        public Node(CovidVariant v) {
            value = v;
            left = right = null;
        }
    }

    static class CovidVariant {
        String name;
        String code;

        public CovidVariant(String name, String code) {
            this.name = name;
            this.code = code;
        }

        @Override
        public String toString() {
            return "CovidVariant{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
    //Compare 2 variant
    public static boolean variant1IsLarger(CovidVariant variant1 , CovidVariant  variant2) {
        if(Integer.parseInt(variant1.code.substring(0,5)) > Integer.parseInt(variant2.code.substring(0,5))) return true;
        if(Integer.parseInt(variant1.code.substring(0,5)) == Integer.parseInt(variant2.code.substring(0,5))) {
            if(variant1.code.charAt(6) > variant2.code.charAt(6)) return true;
        }
        return false;
    }

// Add to the BST
    public VariantCollection() {
        this.root = null;
    }

    public void addVariant(CovidVariant v) {
        Node n = new Node(v);

        // Empty tree?
        if (root == null) {
            root = n;
            return;
        }
        // Find the appropriate location
        Node temp = root;
        while (true) {
            if (variant1IsLarger(temp.value, v)) {
                if (temp.left == null) {
                    temp.left = n;
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = n;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public CovidVariant search(String Code) {
        // Simulate a queue with an array
        Node[] queue = new Node[SIZE];
        int head, tail;
        head = tail = 0;
        // endQueue
        queue[tail] = root;
        tail++;
        while (head < tail) {
            // deQueue
            Node n = queue[head];
            head++;
            //If found, return the result
           if(n.value.code.equals(Code)) {
               System.out.println(n.value);
               return n.value;
           }
            if (n.left != null) {
                // endQueue left child
                queue[tail] = n.left;
                tail++;
            }
            if (n.right != null) {
                // endQueue right child
                queue[tail] = n.right;
                tail++;
            }
        }
        //If no
        System.out.println("Not found");
        return null;
    }

    private CovidVariant previous(String code) {
        Node tmp = this.root;
        CovidVariant v = new CovidVariant("",code);
        boolean found;
        //Use an array to travel backward
        //Ensure the size ofyour array is sufficient
        Node[] visit = new Node[100];
        int start = 0;
        while (true) {
            visit[start] = tmp;
            start ++;
            if(tmp.value.code.equals(code)) {
                found = true;
                break;
            }
            if (variant1IsLarger(tmp.value, v) ) {
                if(tmp.left == null) return null;
                tmp = tmp.left;
            } else {
                if(tmp.right == null) return null;
                tmp = tmp.right;
            }
        }

        if(found) {
            //Find the previous of temp
            //First case: there is a left child of tmp
           if(tmp.left != null) {
               tmp = tmp.left;
               while(tmp.right != null){ tmp = tmp.right;}
               return tmp.value;
           } else {
               start--;

               while (start - 1 >= 0) {
                   //vist[start] current node
                   //visit[start -1 ] parent node
                   if (visit[start - 1].right == visit[start]) return visit[start - 1].value;
                   start--;
               }
               return null;
           }
        }
        return null;
    }
}
