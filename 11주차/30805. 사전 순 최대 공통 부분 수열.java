import java.io.*;
import java.util.*;

public class Main { ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int firstIndex = 0;
        int secondIndex = 0;

        List<Integer> result = new ArrayList<>();
        while (firstIndex < n && secondIndex < m) {
            int max = -1;
            int maxI = -1, maxJ = -1;

            for (int i = firstIndex; i < n; i++) {
                for (int j = secondIndex; j < m; j++) {
                    if (arr1[i] == arr2[j]) {
                        if (arr1[i] > max) {
                            max = arr1[i];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }

            if (max == -1) break;

            firstIndex = maxI + 1;
            secondIndex = maxJ + 1;
            result.add(max);
        }

        System.out.println(result.size());
        for (int r : result) System.out.print(r + " ");
    }
}
