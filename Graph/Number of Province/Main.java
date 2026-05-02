import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] isConnected = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 }
        };

        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = isConnected.length;
        for (int node = 0; node < n; node++) {
            for (int nei = node + 1; nei < n; nei++) {
                if (isConnected[node][nei] == 1) {
                    mp.computeIfAbsent(node, k -> new ArrayList<>()).add(nei);
                    mp.computeIfAbsent(nei, k -> new ArrayList<>()).add(node);
                }
            }
        }
        for (int k : mp.keySet()) {
            System.out.print(k + "-> ");
            for (int v : mp.get(k)) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }

        int ans = s.findCircleNum(isConnected);
        System.out.println("Total number of components =" + ans);
    }
}

class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count += 1;
                dfs(graph, visited, i);
            }
        }
        ;
        return count;
    }

    private void dfs(int[][] graph, Set<Integer> visited, int current) {
        // if(visited.contains(current)){
        // return;
        // };
        visited.add(current);
        for (int i = 0; i < graph.length; i++) {
            if (visited.contains(i) || graph[current][i] == 0) {
                continue;
            }
            dfs(graph, visited, i);
        }
    };
}