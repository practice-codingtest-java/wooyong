import java.io.*;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static int M, N;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            matrix = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (bfs(i, j)) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static boolean bfs(int x, int y) {
        if (matrix[x][y] != 1) return false;

        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            x = point.x;
            y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (matrix[nx][ny] == 0) continue;
                if (matrix[nx][ny] == 1) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return true;
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
