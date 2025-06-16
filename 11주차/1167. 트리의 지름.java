import java.io.*;
import java.util.*;

public class Main { ;
    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Node(to, dist));
            }
        }

        boolean[] visited = new boolean[v + 1];
        int[] distance = new int[v + 1];  //시작 노드로부터 거리 저장

        dfs(1, 0, visited, distance);

        int farNode = 0;
        for (int i = 1; i <= v; i++) {
            if (distance[i] > distance[farNode]) {
                farNode = i;
            }
        }

        visited = new boolean[v + 1];
        distance = new int[v + 1];  //시작 노드로부터 거리 저장

        dfs(farNode, 0, visited, distance);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= v; i++) {
            max = Math.max(max, distance[i]);
        }
        System.out.println(max);
    }

    private static void dfs(int node, int dist, boolean[] visited, int[] distance) {
        visited[node] = true;
        distance[node] = dist;

        for (Node nextNode : graph.get(node)) {
            int nextDist = nextNode.dist + dist;
            if (!visited[nextNode.to]) {
                dfs(nextNode.to, nextDist, visited, distance);
            }
        }
    }

    private static class Node {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
