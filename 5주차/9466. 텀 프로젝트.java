import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> visited = new HashSet<>();
            Set<Integer> result = new HashSet<>();
            List<Integer> cycle = new ArrayList<>();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= n; i++) {
                if (!visited.contains(i)) {
                    dfs(i, visited, result, cycle, graph);
                    cycle.clear();
                }
            }
            System.out.println(n - result.size());
        }
    }

    private static void dfs(int node, Set<Integer> visited, Set<Integer> result, List<Integer> cycle, ArrayList<ArrayList<Integer>> graph) {
        if (visited.contains(node)) return;
        visited.add(node);
        cycle.add(node);

        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);
            if (node == nextNode) {
                result.add(nextNode);
                visited.add(nextNode);
                return;
            }
            if (visited.contains(nextNode) && cycle.contains(nextNode)) {
                for (int j = cycle.indexOf(nextNode); j < cycle.size(); j++) {
                    result.add(cycle.get(j));
                }
            } else if (visited.contains(nextNode)) {
                return;
            } else {
                dfs(nextNode, visited, result, cycle, graph);
            }
        }
    }
}
