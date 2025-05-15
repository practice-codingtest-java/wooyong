import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map.put(arr[0], new ArrayList<>());
        map.get(arr[0]).add(arr[0]);

        for (int i = 1; i < n; i++) {
            int maxIndex = - 1;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (map.get(arr[j]).size() >= max) {
                        max = map.get(arr[j]).size();
                        maxIndex = arr[j];
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(arr[i]);
                continue;
            };

            //ArrayList 초기화 및 복사
            ArrayList<Integer> copied = new ArrayList<>(map.get(maxIndex));
            copied.add(arr[i]);
            map.put(arr[i], copied);
        }

        int maxKey = -1;
        int maxSize = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key).size() >= maxSize) {
                maxKey = key;
                maxSize = map.get(key).size();
            }
        }
        System.out.println(map.get(maxKey).size());
        for (int value : map.get(maxKey)) {
            System.out.print(value + " ");
        }
    }
}
