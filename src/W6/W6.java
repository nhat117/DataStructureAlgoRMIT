package W6;



public class W6 {
    public static void main(String[] args) {
        //Problem 1
        W6Tree tree = new W6Tree();
        for(int i = 0; i < 10; i ++) {
            tree.insertBST((int)(Math.random() * 100));
        }

        //Problem 2
        tree.startPreorder();
        tree.startInOrder();
        tree.startPostOrder();
        tree.breadthFirst();
        //Problem 3
        System.out.println("Tree Height" + tree.treeHeight());

        //Problem4 Determine the height if
        W6Tree tree2 = new W6Tree();
        for(int i = 0; i < 10; i ++) {
            tree2.randomInsert((int)Math.random() * 100);
        }
        tree2.printTree();
        System.out.println("Is BST, range chk: " + tree.isBST());
        System.out.println("Is BST, in order chkc :" + tree.isBST2());
    }

    static class W6Node{
        public Object value;
        public W6Node l, r;
        //A typical tree node
        public W6Node(Object value) {
            this.value = value;
        }
    }

    static  class  W6Tree {
        public W6Node root;
        //Usefull in inorder traversal
        public int lastValue;
        public boolean isIncrease;

        //For Display
        int row = 10;
        int cols = 80;
        char [][] canvas = new char[row][cols];

        public W6Tree() {
            root = null;
            for (int i = 0; i < row; i ++) {
                for(int j = 0; j < cols; j ++) {
                    canvas[i][j] = ' ';
                }
            }
        }


        //Problem 1
        /*
            Implement a BST of integers with the insert operation. Display the number of steps it takes to find the correct position for the newly inserted value. Generate several random integers and insert them into the BST.
         */
        public void insertBST(Integer v) {
            W6Node tmp = new W6Node(v);
            int step = 1;
            if(this.root == null) {
                this.root = tmp;
                System.out.printf("Insert: %d, number of steps: %d \n",v, step);
                return;
            }

            //Find the suitable location
            W6Node tmp2 = root;
            while (true) {
                //Abort if duplicated
                if(tmp2.value == v) {
                    System.out.printf("Insert: %d, number of steps: %d\n",v,step);
                    return;
                }
                step ++;
                if((Integer)tmp2.value > v) {
                    if(tmp2.l == null) {
                        tmp2.l = tmp;
                        break;
                    } else {
                        tmp2 = tmp2.l;
                    }
                } else {
                    if(tmp2.r == null) {
                        tmp2.r = tmp;
                        break;
                    } else {
                        tmp2 = tmp2.r;
                    }
                }
            }
            System.out.printf("Insert: %d, number of step: %d \n", v, step);
        }

        //Problem 2
        //Preorder Traversal
        public void startPreorder() {
            System.out.println("Preorder Traversal");
            preOrder(root);
        }

        private void preOrder(W6Node n) {
            if(n == null) {
                return;
            }
            System.out.println(n.value);
            preOrder(n.l);
            preOrder(n.r);
        }
        //InOrder Traversal
        public void startInOrder() {
            System.out.println("InOrder traversal");
            inOrder(root);
        }

        public void inOrder(W6Node n) {
            if( n == null) return;
            inOrder(n.l);
            System.out.println(n.value);
            inOrder(n.r);
        }

        public void startPostOrder() {
            System.out.println("Post-order traversal");
            postOrder(root);
        }
        //Use to delete the tree
        public void postOrder(W6Node n) {
            if(n == null) return;
            postOrder(n.l);
            postOrder(n.r);
            System.out.println((int)n.value);
        }
        //Implementation of breadFirst

         public void breadthFirst() {
             System.out.println("Breadth first");
             //Queue
             W6Node [] q = new W6Node[100];
             int h, t;
             h = t = 0;
             //EndQ
             q[t] = root;
             t ++;
             while( h < t) {
                 W6Node tmp = q[h];
                 h ++;
                 System.out.println(tmp.value);
                 if(tmp.l != null) {
                     q[t] = tmp.l;
                     t ++;
                 }
                 if(tmp.r != null) {
                     q[t] = tmp.r;
                     t ++;
                 }
             }
          }

        // Problem 3
        //Return the height of a tree
        public int treeHeight() {
            return  nodeHeight(root);
        }

        private int nodeHeight(W6Node n) {
            if(n == null) return 0;

        return Math.max(nodeHeight(n.l), nodeHeight(n.r) + 1);
        }

        //Problem 4
        public boolean isBST() {
            return isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBST(W6Node n, int min, int max) {
            if(n == null) return true;
            if((int)n.value < min || (int) n.value > max) return false;
            return isBST(n.l, min, (int)n.value -1) && isBST(n.r, (int)n.value + 1, max);
        }

        public boolean isBST2() {
            //Using in order traversal
            lastValue = Integer.MIN_VALUE;
            isIncrease = true;
            isBSTInorder(root);
            return  isIncrease;
        }

        private void  isBSTInorder(W6Node n) {
            if(n == null || !isIncrease) {
                return;
            }
            isBSTInorder(n.l);
            if(lastValue >= (int)n.value) {
                isIncrease = false;
                return;
            } else {
                lastValue = (int)n.value;
            }
            isBSTInorder(n.r);
        }

        //Random insert
        public void randomInsert(int v){
            W6Node n = new W6Node(v);
            if(root == null) {
                root = n;
                return;
            }
            W6Node tmp = root;
            while (true) {
                //Choose l or r randomly
                if(Math.random() < 0.5) {
                    if(tmp.l == null) {
                        tmp.l = n;
                        return;
                    }
                    tmp = tmp.l;
                } else {
                    if(tmp.r == null) {
                        tmp.r = n;
                        return;
                    }
                    tmp = tmp.r;
                }
            }
        }

        public void printTree() {
            fillCanvas(root, 0, 0, cols);
            for(int i = 0; i < row; i ++) {
                for (int j = 0; j < cols; j ++) {
                    System.out.println(canvas[i][j]);
                }
                System.out.println();
                System.out.println();
            }
        }

        private void fillCanvas(W6Node n, int r, int start, int w) {
            if(n == null) return;

            char [] v = String.valueOf((int)n.value).toCharArray();
            int st = start + w /2 - v.length /2;
            for(int i = 0; i < v.length; i ++) {
                canvas[r][st + i] = v[i];
            }
            fillCanvas(n.l, r+ 1, start, w/2);
            fillCanvas(n.r, r+ 1, start + w /2, w/2);
        }
    }
}
