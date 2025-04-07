import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visited[arr[i]] = true;
        }
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int target = x - arr[i];
            visited[arr[i]] = false;
            if (target > 0 && target <= 1000000 && visited[target]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
