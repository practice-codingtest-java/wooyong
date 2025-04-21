import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            Map<String, String> map = new HashMap<>();
            HashSet<String> visited = new HashSet<>();
            int result = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            for (String key : map.keySet()) {
                if (!visited.contains(key)) {
                    while (!visited.contains(key)) {
                        visited.add(key);
                        key = map.get(key);
                    }
                    result++;
                }
            }
            testCnt++;

            System.out.println(testCnt + " " + result);
        }
    }
}
