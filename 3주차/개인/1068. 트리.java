import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] arr = new int[51];
    static boolean[] visited = new boolean[51];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int root = -2;

        //내부 리스트 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //m 제외한 노드 그래프에 추가
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] == -1) {
                root = i;
                continue;
            }
            if (i == m || arr[i] == m) {
                continue;
            }
            graph.get(arr[i]).add(i);
        }

        if (m != root) {
            dfs(root);
        }

        System.out.println(cnt);
    }

    private static void dfs(int n) {
        if (!visited[n] && graph.get(n).isEmpty()) {
            cnt++;
        }
        visited[n] = true;

        for (int i = 0 ; i < graph.get(n).size() ; i++) {
            Integer m = graph.get(n).get(i);
            if (!visited[m]) {
                dfs(m);
            }
        }
    }
}
