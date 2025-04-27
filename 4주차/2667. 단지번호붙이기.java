import java.io.*;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static boolean[][] visited;
    public static int n;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int result = bfs(i, j);
                    if (result != 0) {
                        list.add(result);
                    }
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int c : list) {
            System.out.println(c);
        }
    }

    public static int bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            x = point.x;
            y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (matrix[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }
        return cnt;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
