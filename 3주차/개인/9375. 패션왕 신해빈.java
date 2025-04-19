import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String types = st.nextToken();
                map.put(types, map.getOrDefault(types, 0) + 1);
            }

            int result = 1;
            for (String key : map.keySet()) {
                result *= (map.get(key) + 1);
            }
            System.out.println(result - 1);
        }
    }
}
