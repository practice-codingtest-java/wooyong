import java.io.*;
import java.util.*;

public class Main {

    //그래프의 각 노드의 인접 노드 리스트를 `정렬된 상태`로 유지하고 싶다!! -> TreeSet
    static ArrayList<TreeSet<Integer>> graph = new ArrayList<TreeSet<Integer>>();
    static Set<Integer> visitedDfs = new HashSet<>();
    static Set<Integer> visitedBfs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void dfs(int node) {
        visitedDfs.add(node);
        System.out.print(node + " ");

        //TreeSet은 인덱스 접근이 불가능 하므로, 향상된 for문으로 순회
        for (int nextNode : graph.get(node)) {
            if (!visitedDfs.contains(nextNode)) {
                dfs(nextNode);
            }
        }
    }

    private static void bfs(int root) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        visitedBfs.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int nextNode : graph.get(node)) {
                if (!visitedBfs.contains(nextNode)) {
                    queue.offer(nextNode);
                    visitedBfs.add(nextNode);
                }
            }
        }
    }
}
