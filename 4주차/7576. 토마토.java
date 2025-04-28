import java.io.*;
import java.util.*;

public class Main {

    public static int[][] matrix;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        Set<Point> startPoints = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) {
                    startPoints.add(new Point(i, j));
                }
            }
        }

        Deque<Point> queue = new ArrayDeque<>();
        for (Point p : startPoints) {
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (matrix[nx][ny] == -1) continue;
                if (matrix[nx][ny] != 0) continue;

                matrix[nx][ny] = matrix[x][y] + 1;
                queue.offer(new Point(nx, ny));
            }
        }

        int max = -1;
        boolean enabled = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    enabled = false;
                }
                max = Math.max(max, matrix[i][j]);
            }
        }

        if (enabled) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
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
}
