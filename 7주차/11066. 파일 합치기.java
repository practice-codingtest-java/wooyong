import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] files = new int[k];
            int[] prefixSum = new int[k + 1];
            int[][] dp = new int[k][k];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefixSum[i + 1] = prefixSum[i] + files[i];
            }

            for (int len = 2; len <= k; len++) {
                for (int i = 0; i <= k - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int l = i; l < j; l++) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][l] + dp[l + 1][j] + prefixSum[j + 1] - prefixSum[i]);
                    }
                }
            }
            System.out.println(dp[0][k - 1]);
        }
    }
}
