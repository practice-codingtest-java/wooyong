import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //정점
        int m = Integer.parseInt(st.nextToken());  //간선
        int k = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int weight = i;
            edges.add(new Edge(from, to, weight));
        }

        for (int start = 0 ; start < k ; start++) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;

            int totalWeight = 0;
            int edgeCount = 0;

            for (int i = start ; i < m ; i++) {
                Edge edge = edges.get(i);
                if (union(edge.from, edge.to)) {
                    totalWeight += edge.weight;
                    edgeCount++;
                    if (edgeCount == n - 1) break;
                }
            }
            System.out.print(((edgeCount == n - 1) ? totalWeight : 0) + " ");
        }
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
