import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0 ; i <  cards.length - 2 ; i++){
            for(int j = i + 1 ; j < cards.length - 1 ; j++){
                for(int l = j + 1 ; l < cards.length ; l++){
                    set.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        if (list.size() >= k) {
            System.out.println(list.get(k - 1));
        } else {
            System.out.println("-1");
        }
    }
}
