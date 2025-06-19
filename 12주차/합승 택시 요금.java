import java.util.*;

public class Main { ;

    private static List<List<Node>> graph = new ArrayList<>();
    private static int[][] dist;

    public static void main(String[] args) {
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

        System.out.println(solution(7, 3, 4, 1, fares));
    }

    private static int solution(int n, int s, int a, int b, int[][] fares) {

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < fares.length ; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        dijkstra(s);
        dijkstra(a);
        dijkstra(b);
        // 처음에는 모든 노드에 대해 dijkstra알고리즘을 적용했는데, 효율성 테스트에서 48.3 / 50.0을 받아 필요한 노드만 적용하도록 개선

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i <= n ; i++) {
            minDist = Math.min(minDist, dist[s][i] + dist[a][i] + dist[b][i]);
        }

        return minDist;
    }

    private static void dijkstra(int start) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.cost - o2.cost
        );

        pq.offer(new Node(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;
            int currentCost = currentNode.cost;

            if (visited.contains(currentVertex)) continue;
            visited.add(currentVertex);

            for (Node nextNode : graph.get(currentVertex)) {
                int nextCost = currentCost + nextNode.cost;
                if (nextCost < dist[start][nextNode.vertex]) {
                    dist[start][nextNode.vertex] = nextCost;
                    pq.offer(new Node(nextNode.vertex, nextCost));
                }
            }
        }
    }

    private static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
