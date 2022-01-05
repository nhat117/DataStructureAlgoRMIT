package W11;

import java.util.ArrayList;

public class KnapSack {
    static int [][] globalV = null; //For the top down version

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int knapsack(Item [] items, int capacity) {
        //Dynamic programming solution to the knapsack
        int n = items.length;
        int[][] v = new int[n + 1][capacity + 1];

        //Denoted whether an item i of knapsack capacity is selected or not
        //Taken[i][j] = true if item i is selected, false otherwise

        boolean[][] taken = new boolean[n + 1][capacity + 1];
        //Init
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                v[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j) {
                    //If the item is too heavy to put on the knapsack
                    //So, the max value of the item should not increase
                    v[i][j] = v[i - 1][j];
                    continue;
                }
                //If it is okay, put into the knapsack
                if (v[i - 1][j - items[i - 1].weight] + items[i - 1].value > v[i - 1][j]) {
                    v[i][j] = v[i - 1][j - items[i - 1].weight] + items[i - 1].value;
                    taken[i][j] = true;
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }
        //Rebuild the solution
        ArrayList<Integer> res = new ArrayList<>();
        int cap = capacity;
        int last = n;
        while (cap > 0 && last < 0) {
            if (taken[last][cap]) {
                //The last-th index item is taken
                res.add(last - 1);
                cap -= items[last - 1].weight;
            }
            last--;
        }

        //Output
        System.out.println("Items selected");
        for (int index : res) {
            System.out.printf("(w: %d, v:%d)", items[index].weight, items[index].value);
        }
        System.out.println("\n--------");
        return v[n][capacity];
    }
}
