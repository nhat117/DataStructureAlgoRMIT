package W11;

import java.util.Arrays;
/*
The list of cities and their direct distances are given in a 2D array. For example

distances = [
  [0, 3, 2, -1]
  [3, 0, -1, 5],
  [2, -1, 0, 9]
  [-1, 5, 9, 0]
]
Explanation: the value at cell [i, j] represents the distance between city i and city j. The distance between a city and itself is zero (i.e., [i, i] = 0 for every i). If there is no direct path between city i and j, then [i, j] = -1.

Implement a program to calculate the shortest path's length from the first city (index 0) to the last city (index n - 1, n is the number of cities).

In the above example, there are 2 paths from city 0 to city 3

0 -> 1 -> 3 (length 3 + length 5 = 8)

0 -> 2 -> 3 (length 2 + length 9 = 11)

So, the shortest path is: 0 -> 1 -> 3

Note: all valid paths have distance > 0
 */
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
        //Adaptation of Dịkstra
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
