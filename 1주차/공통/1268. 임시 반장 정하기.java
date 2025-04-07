import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] classes = new int[n][5];
        boolean [][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] cnt = new int[n];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j == k) continue;
                    if(classes[j][i] == classes[k][i] && !visited[j][k]) {
                        cnt[j]++;
                        visited[j][k] = true;
                    }
                }
            }
        }

        System.out.println(getMaxIndex(cnt));
    }

    private static int getMaxIndex(int[] cnt) {
        int maxIndex = 0;
        for (int i = 1; i < cnt.length; i++) {
            if(cnt[i] > cnt[maxIndex]) maxIndex = i;
        }
        return maxIndex + 1;
    }
}
