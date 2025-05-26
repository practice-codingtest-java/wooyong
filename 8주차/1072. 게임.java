import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int initialOdds = calculateOdds((double) x, (double) y);
        int result = -1;

        int start = 0;
        int end = 1000000000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (calculateOdds(x + mid, y + mid) != initialOdds) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int calculateOdds(double x, double y) {
        return (int) ((y * 100 / x));
    }
}
