import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = n * n;
        long result = -1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = calculateCount(mid, n);


            if (cnt < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }

    private static long calculateCount(long mid, long n) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(n, mid / i);
        }
        return cnt;
    }
}
