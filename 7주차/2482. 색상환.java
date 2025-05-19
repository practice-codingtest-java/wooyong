import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        final long mod = 1000000003;
        long[][] dp = new long[n + 1][k + 1];

        if (k > n / 2) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 2 ; i <= n ; i++) {
            for (int j = 2 ; j <= k ; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        System.out.println((dp[n - 1][k] + dp[n - 3][k - 1]) % mod);
    }
}
