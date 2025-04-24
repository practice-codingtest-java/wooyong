import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static Set<Integer> visited = new HashSet<>();
    public static int cnt = 0;
    public static Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(1);

        if (cnt % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static void bfs(int root) {
        int[] depth = new int[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0 ; i < graph.get(x).size() ; i++) {
                int y = graph.get(x).get(i);
                if(!visited.contains(y)) {
                    queue.offer(y);
                    visited.add(y);
                    depth[y] = depth[x] + 1;
                }
                if (graph.get(y).size() == 1 && y != root) {
                    cnt += depth[y];
                }
            }
        }
    }
}
