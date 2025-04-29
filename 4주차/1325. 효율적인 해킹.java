import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int n;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        result = new int[n + 1];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }

        for (int i = 1 ; i <= n ; i++) {
            boolean[] visited = new boolean[n + 1];
            result[i] = dfs(i, visited);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static int dfs(int node, boolean[] visited) {
        int cnt = 1;
        visited[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) cnt += dfs(nextNode, visited);
        }
        return cnt;
    }
}
