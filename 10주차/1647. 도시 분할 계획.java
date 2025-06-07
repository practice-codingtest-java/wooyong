import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );

        boolean[] visited = new boolean[N + 1];
        int totalWeight = 0;
        int maxWeight = 0;
        int start = 1;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;

            visited[node.to] = true;
            totalWeight += node.weight;
            maxWeight = Math.max(maxWeight, node.weight);

            for (Node nextNode : graph.get(node.to)) {
                if (!visited[nextNode.to]) pq.offer(nextNode);
            }
        }
        System.out.println(totalWeight - maxWeight);
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
