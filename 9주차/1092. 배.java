import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if (crane[0] < boxes[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        boolean[] visited = new boolean[m];
        int movedBoxes = 0;

        while (movedBoxes < m) {
            int boxIdx = 0;
            for (int i = 0; i < n; i++) {
                while (boxIdx < m) {
                    if (!visited[boxIdx] && crane[i] >= boxes[boxIdx]) {
                        visited[boxIdx] = true;
                        boxIdx++;
                        movedBoxes++;
                        break;
                    }
                    boxIdx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
