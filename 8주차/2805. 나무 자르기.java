import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, m));
    }

    private static long binarySearch(int[] arr, int target) {
        long start = 0;
        long end = arr[arr.length - 1];
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i : arr) {
                if (i > mid) sum += (i - mid);
            }
            if (sum == target) return mid;
            else if (sum > target) {
                result = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return result;
    }
}
