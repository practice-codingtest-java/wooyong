import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>();  //입력 순서 저장
        Set<String> result = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            map.put(word, 0);
            list.add(word);
        }

        for (String word : map.keySet()) {
            String nextWord = map.higherKey(word);
            if (nextWord == null) break;
            for (int i = 1; i <= word.length(); i++) {
                if (nextWord.startsWith(word.substring(0, i))) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (String word : map.keySet()) {
            max = Math.max(max, map.get(word));
        }

        for (String word : map.keySet()) {
            if (map.get(word) == max) result.add(word);
        }
        for (String word : map.keySet()) {
            for (String r : result) {
                if (word.startsWith(r.substring(0, max))) {
                    map.put(word, map.get(r));
                }
            }
        }

        String first = null;
        for (String word : list) {
            if (map.containsKey(word) && map.get(word) == max) {
                first = word;
                break;
            }
        }
        System.out.println(first);

        for (String word : list) {
            if (word.equals(first)) continue;
            if (word.length() < max) continue;
            if (first.startsWith(word.substring(0, max)) || word.startsWith(first.substring(0, max))) {
                System.out.println(word);
                break;
            }
        }
    }
}
