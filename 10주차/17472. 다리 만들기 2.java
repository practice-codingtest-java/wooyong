import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] matrix;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 구역 나누기
        int islandNum = 2;
        int V = 0;  //정점 개수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    markIsland(i, j, islandNum++);
                    V++;
                }
            }
        }

        //그래프 간선 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V + 2 ; i++) {
            graph.add(new ArrayList<>());
        }

        //섬끼리 가능한 다리 정보 추출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] >= 2) {
                    int from = matrix[i][j];

                    for (int k = 0; k < 4; k++) {
                        int nx = i;
                        int ny = j;
                        int length = 0;

                        while (true) {
                            nx += dx[k];
                            ny += dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
                            if (matrix[nx][ny] == from) break;
                            if (matrix[nx][ny] == 0) {
                                length++;
                                continue;
                            }

                            if (matrix[nx][ny] != from && length >= 2) {
                                int to = matrix[nx][ny];
                                graph.get(from).add(new Node(to, length));
                            }
                            break;
                        }
                    }
                }
            }
        }

        //MST 수행(Prim)
        boolean[] visited = new boolean[V + 2];
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );

        int start = 2;
        pq.offer(new Node(start, 0));
        int totalWeight = 0;
        int edgeCount = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;

            visited[node.to] = true;
            totalWeight += node.weight;
            edgeCount++;

            for (Node nextNode : graph.get(node.to)) {
                if (!visited[nextNode.to]) pq.offer(nextNode);
            }
        }
        System.out.println((edgeCount == V) ? totalWeight : -1);
    }

    private static void markIsland(int x, int y, int islandNum) {
        Deque<Point> queue = new ArrayDeque<>();
        matrix[x][y] = islandNum;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (matrix[nx][ny] != 1) continue;

                matrix[nx][ny] = islandNum;
                queue.offer(new Point(nx, ny));
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
