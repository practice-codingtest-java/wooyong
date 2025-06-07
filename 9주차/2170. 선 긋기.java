import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        list.sort((a, b) -> a.x - b.x);

        int totalLength = 0;

        int start = list.get(0).x;
        int end = list.get(0).y;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).x <= end) {
                end = Math.max(end, list.get(i).y);
            } else {
                totalLength += (end - start);
                start = list.get(i).x;
                end = list.get(i).y;
            }
        }
        totalLength += (end - start);
        System.out.println(totalLength);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
