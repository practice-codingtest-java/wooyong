import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] matrix = new char[n][m];

        int rx = 0, ry = 0;
        int bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
                if (str.charAt(j) == 'B') {
                    bx = i;
                    by = j;
                } else if (str.charAt(j) == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(bx, by, rx, ry));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.dist >= 10) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; i++) {

                int rnx = node.rx, rny = node.ry;
                int bnx = node.bx, bny = node.by;
                boolean redPassed = false, bluePassed = false;

                //빨간공
                int redCount = 0;
                while (true) {
                    rnx += dx[i];
                    rny += dy[i];
                    redCount++;
                    if (matrix[rnx][rny] == '#') {
                        rnx -= dx[i];
                        rny -= dy[i];
                        redCount--;
                        break;
                    }
                    else if (matrix[rnx][rny] == 'O') {
                        redPassed = true;
                        break;
                    }
                }

                //파란공
                int blueCount = 0;
                while (true) {
                    bnx += dx[i];
                    bny += dy[i];
                    blueCount++;
                    if (matrix[bnx][bny] == '#') {
                        bnx -= dx[i];
                        bny -= dy[i];
                        blueCount--;
                        break;
                    }
                    else if (matrix[bnx][bny] == 'O') {
                        bluePassed = true;
                        break;
                    }
                }

                if (redPassed && !bluePassed) {
                    System.out.println(node.dist + 1);
                    return;
                }
                else if (bluePassed && !redPassed || redPassed && bluePassed) continue;

                if (rnx == bnx && rny == bny) {
                    //멀리서 온거 한칸 뒤로
                    if (redCount > blueCount) {
                        rnx -= dx[i];
                        rny -= dy[i];
                    } else {
                        bnx -= dx[i];
                        bny -= dy[i];
                    }
                }
                if (rnx == node.rx && rny == node.ry && bnx == node.bx && bny == node.by) continue;
                queue.offer(new Node(bnx, bny, rnx, rny, node.dist + 1));
            }
        }
        System.out.println(-1);
    }

    private static class Node {
        int bx, by;
        int rx, ry;
        int dist;

        public Node(int bx, int by, int rx, int ry) {
            this.bx = bx;
            this.by = by;
            this.rx = rx;
            this.ry = ry;
            this.dist = 0;
        }

        public Node(int bx, int by, int rx, int ry, int dist) {
            this.bx = bx;
            this.by = by;
            this.rx = rx;
            this.ry = ry;
            this.dist = dist;
        }
    }
}
