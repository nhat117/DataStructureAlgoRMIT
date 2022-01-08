package W11;

import java.util.Arrays;

public class Djkstra {
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
            for(int i = 0)
        }

    }
}
rent