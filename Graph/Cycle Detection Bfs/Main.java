// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;

class Main {
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 3 }
        };
        int vertices = 4;
        int nodes = 4;
        Solution s = new Solution();
        boolean isPresent = s.isCycle(nodes, edges);

        System.out.println("Cycle is " + (isPresent ? "" : "not ") + "present");
    }
}

class Solution {
    public boolean isCycle(int nodes, int[][] edges) {
        // Code here
        int[] visited = new int[nodes];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 1)
                continue;
            if (bfs(i, visited, adjacencyList))
                return true;
        }

        return false;
    }

    boolean bfs(int current, int[] visited, List<List<Integer>> connections) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { current, -1 });
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int node = top[0];
            int parent = top[1];
            for (int nei : connections.get(node)) {
                if (visited[nei] == 0) {
                    visited[nei] = 1;
                    q.add(new int[] { nei, node });
                } else if (nei != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}