package W11;

import java.util.Arrays;

public class Djkstra {
    public static void main(String[] args) {
        int[][] distances = {
                {0, 3, 2, -1},
                {3, 0, -1, 5},
                {2, -1, 0, 9},
                {-1, 5, 9, 0}
        };
        System.out.println(shortestPath(distances, 0, 3));
    }
    static int shortestPath(int[][] nodes, int src, int dest) {
        //Adaptation ò Dịkstra
        int n = nodes.length;

        int [] distance = new int[n];
        //Distances[i[ store the minimum distance from src to i
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0; //Zero Distance from the src itsekf

        boolean[] visited = new boolean[n];
        visited[src] = true;

        int current = src;
        while(true) {
            for(int i = 0; i < n;i ++) {
                if(visited[i]) {
                    continue;
                }
                if(nodes[current][i] > 0) {
                    //Current and i are connected
                    if(distance[i] > distance[current] + nodes[current][i]) {
                        distance[i] = distance[current] + nodes[current][i];
                    }
                }
            }
            //Use the shortest distance node as the new currnet
            //A priority queue here to improve the swarch
            int shortest =Integer.MAX_VALUE;
            for(int i = 0; i < n; i ++) {
                if(visited[i]) continue;
                if(shortest > distance[i]) {
                    shortest = distance[i];
                    current = i;
                }
            }
            //Reach the destination
            if(current == dest) {
                return distance[dest];
            }

            //Cannot go further
            if(shortest == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            visited[current] = true;
        }
    }
}
