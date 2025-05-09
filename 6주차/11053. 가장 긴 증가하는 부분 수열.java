import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0 ; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, result[j]);
                }
            }
            if (max == Integer.MIN_VALUE) result[i] = 1;
            else result[i] = max + 1;
        }

        Arrays.sort(result);
        System.out.println(result[n - 1]);
    }
}
