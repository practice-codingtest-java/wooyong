import java.io.*;
import java.util.*;

public class Main {
    public static char[][] matrix;
    public static int[][] fireVisited;
    public static int[][] jhVisited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        matrix = new char[r][c];
        fireVisited = new int[r][c];
        jhVisited = new int[r][c];

        Deque<Node> fireQueue = new ArrayDeque<>();
        Deque<Node> jihoonQueue = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fireVisited[i][j] = -1;
                jhVisited[i][j] = -1;
            }
        }

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'J') {
                    jihoonQueue.offer(new Node(i, j, 0));
                    jhVisited[i][j] = 0;
                } else if (matrix[i][j] == 'F') {
                    fireQueue.offer(new Node(i, j, 0));
                    fireVisited[i][j] = 0;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Node node = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (matrix[nx][ny] == '#') continue;
                if (fireVisited[nx][ny] != -1) continue;

                fireVisited[nx][ny] = node.time + 1;
                fireQueue.offer(new Node(nx, ny, fireVisited[nx][ny]));
            }
        }

        while (!jihoonQueue.isEmpty()) {
            Node node = jihoonQueue.poll();

            if (node.x == 0 || node.y == 0 || node.x == r - 1 || node.y == c - 1) {
                System.out.println(node.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (matrix[nx][ny] == '#') continue;
                if (jhVisited[nx][ny] != -1) continue;

                jhVisited[nx][ny] = node.time + 1;
                if (fireVisited[nx][ny] != -1 && fireVisited[nx][ny] <= jhVisited[nx][ny]) continue;

                jihoonQueue.offer(new Node(nx, ny, jhVisited[nx][ny]));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Node {
        int x, y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
