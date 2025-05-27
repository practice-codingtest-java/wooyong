import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] high = new int[h + 1];
        int[] low = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            if (i % 2 == 0) low[size]++;
            else high[size]++;
        }

        for (int i = h - 1; i >= 1; i--) {
            low[i] += low[i + 1];
            high[i] += high[i + 1];
        }

        int[] arr = new int[h + 1];
        for (int i = 1; i <= h; i++) {
            arr[i] = high[i] + low[h + 1 - i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= h; i++) {
            min = Math.min(min, arr[i]);
        }

        int cnt = 0;
        for (int i = 1 ; i <= h; i++) {
            if (arr[i] == min) cnt++;
        }

        System.out.println(min + " " + cnt);
    }
}
