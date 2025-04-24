import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static Map<Integer, Integer> map = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n + 1 ; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);

        for (int i = 2 ; i <= n ; i++) {
            System.out.println(map.get(i));
        }
    }

    private static void dfs(int node) {
        visited.add(node);
        for (int i = 0 ; i < graph.get(node).size() ; i++) {
            int nextNode = graph.get(node).get(i);
            if (!visited.contains(nextNode)) {
                map.put(nextNode, node);
                dfs(nextNode);
            }
        }
    }
}
