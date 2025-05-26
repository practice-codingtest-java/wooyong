import java.io.*;
import java.util.*;

public class CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(arr, c));
    }

    private static int binarySearch(int[] arr, int c) {
        int start = 0;
        int end = arr[arr.length - 1];
        int result = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;

            if (countInstall(arr, mid) < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
        return result;
    }

    private static int countInstall(int[] arr, int distance) {
        int cnt = 1;
        int router = arr[0];

        for (int i = 1 ; i < arr.length; i++) {
            if (arr[i] - router >= distance) {
                router = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
