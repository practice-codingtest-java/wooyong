import java.util.*;
import java.io.*;

public class Main {
    private static int[][] batting;
    private static int n;
    private static int[] order = new int[9];
    private static boolean[] visited = new boolean[9];
    private static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        batting = new int[n][9];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0 ; j < 9 ; j++) {
                batting[i][j] = Integer.parseInt(str[j]);
            }
        }

        order[3] = 0;
        visited[0] = true;

        permute(0);
        System.out.println(maxScore);
    }

    private static void permute(int depth) {
        if (depth == 9) {
            maxScore = Math.max(maxScore, play());
            return;
        }

        if (depth == 3) {
            permute(depth + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int play() {
        int score = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            int out = 0;
            int[] base = {0, 0, 0};

            while (out < 3) {
                int result = batting[i][order[j % 9]];
                if (result == 0) out++;
                else if (result == 1) {
                    score += base[2];
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = 1;
                } else if (result == 2) {
                    score += base[2] + base[1];
                    base[2] = base[0];
                    base[1] = 1;
                    base[0] = 0;
                } else if (result == 3) {
                    score += base[2] + base[1] + base[0];
                    base[0] = 0;
                    base[1] = 0;
                    base[2] = 1;
                } else if (result == 4) {
                    score += base[2] + base[1] + base[0] + 1;
                    base[0] = 0;
                    base[1] = 0;
                    base[2] = 0;
                }
                j++;
            }
        }
        return score;
    }
}
