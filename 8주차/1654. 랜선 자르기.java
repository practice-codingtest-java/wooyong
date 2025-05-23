import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, n));
    }

    private static long binarySearch(int[] arr, int target) {
        long start = 1, end = arr[arr.length - 1];
        long result = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int i = 0 ; i < arr.length ; i++) {
                count += (arr[i] / mid);
            }

            if (count >= target) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
