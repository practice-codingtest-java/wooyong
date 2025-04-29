import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n, m;
    public static int min = Integer.MAX_VALUE;
    public static List<Node> houses = new ArrayList<>();
    public static List<Node> chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) houses.add(new Node(i, j));
                if (matrix[i][j] == 2) chickens.add(new Node(i, j));
            }
        }
        combination(0, new ArrayList<>());
        System.out.println(min);
    }

    private static void combination(int start, List<Node> selected) {
        // m개 치킨집 골랐으면 거리 계산
        if (selected.size() == m) {
            countChickenDistance(selected);
            return;
        }

        // 치킨집 고르는 과정
        for (int i = start ; i < chickens.size() ; i++) {
            selected.add(chickens.get(i));
            combination(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private static void countChickenDistance(List<Node> selected) {
        int sum = 0;
        for (Node house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Node chicken : selected) {
                minDistance = Math.min(Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y), minDistance);
            }
            sum += minDistance;
        }
        min = Math.min(min, sum);
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
