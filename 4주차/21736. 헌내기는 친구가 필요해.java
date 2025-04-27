import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        int rootX = -1, rootY = -1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    rootX = i;
                    rootY = j;
                }
            }
        }
        int result = bfs(rootX, rootY);

        if (result == 0) System.out.println("TT");
        else System.out.println(result);
    }

    public static int bfs(int x, int y) {
        int cnt = 0;
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            x = point.x;
            y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 'X') continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'P') {
                    cnt++;
                }
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
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
