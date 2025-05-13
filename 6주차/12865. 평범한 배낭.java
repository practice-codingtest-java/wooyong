import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products.add(new Product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < n; i++) {
            Product p = products.get(i);
            //뒤에서부터 순회 -> 물건을 딱 한 번만 사용하는 경우로 처리
            for (int j = k; j >= 0; j--) {
                if (j >= p.weight) {
                    dp[j] = Math.max(dp[j], dp[j - p.weight] + p.value);
                }
            }
        }
        System.out.println(dp[k]);
    }

    private static class Product {
        int weight;
        int value;

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
