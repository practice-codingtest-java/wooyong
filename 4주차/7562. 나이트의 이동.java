import java.io.*;
import java.util.*;

public class Main {
    public static int[][] matrix;
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            matrix = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Deque<Point> queue = new ArrayDeque<>();
            queue.offer(new Point(startPoint.x, startPoint.y));

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                    if (matrix[nx][ny] != 0) continue;
                    if (nx == startPoint.x && ny == startPoint.y) continue;
                    if (nx == endPoint.x && ny == endPoint.y) {
                        matrix[nx][ny] = matrix[x][y] + 1;
                        break;
                    }

                    matrix[nx][ny] = matrix[x][y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }

            System.out.println(matrix[endPoint.x][endPoint.y]);
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
