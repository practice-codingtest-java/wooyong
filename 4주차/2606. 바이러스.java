import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int cnt = 0;
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntNode = Integer.parseInt(br.readLine());
        int cntEdge = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= cntNode; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < cntEdge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int node) {
        visited.add(node);
        for (int i = 0 ; i < graph.get(node).size() ; i++) {
            int nextNode = graph.get(node).get(i);
            if (!visited.contains(nextNode)) {
                cnt++;
                dfs(nextNode);
            }
        }
    }
}
