import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] stockList = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i++) {
                stockList[i] = Integer.parseInt(st.nextToken());
            }

            int max = stockList[n - 1];
            long sum = 0;
            for (int i = n - 2 ; i >= 0 ; i--) {
                if (stockList[i] > max) {
                    max = stockList[i];
                    continue;
                }
                sum += (max - stockList[i]);
            }
            System.out.println(sum);
        }
    }
}
