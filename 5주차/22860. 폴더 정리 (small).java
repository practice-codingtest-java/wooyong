import java.io.*;
import java.util.*;

public class Main {
    static Map<String, List<Node>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            String c = st.nextToken();

            if (!map.containsKey(x)) map.put(x, new ArrayList<>());
            map.get(x).add(new Node(y, Integer.parseInt(c)));
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            String input = br.readLine();
            HashSet<String> visited = new HashSet<>();
            HashSet<String> typeCnt = new HashSet<>();
            ArrayList<String> totalCnt = new ArrayList<>();

            // split으로 문자열 추출
            String[] parts = input.split("/");
            input = parts[parts.length - 1];

            dfs(input, visited, typeCnt, totalCnt);
            System.out.println(typeCnt.size() + " " + totalCnt.size());
        }
    }

    private static void dfs(String input, Set<String> visited, Set<String> typeCnt, List<String> totalCnt) {
        if (!map.containsKey(input)) return;
        visited.add(input);
        for (Node node : map.get(input)) {
            if (node.isFolder == 0) {
                visited.add(node.name);
                typeCnt.add(node.name);
                totalCnt.add(node.name);
            } else if (node.isFolder == 1 && !visited.contains(node.name)) {
                dfs(node.name, visited, typeCnt, totalCnt);
            }
        }
    }

    private static class Node {
        String name;
        int isFolder;

        public Node(String name, int isFolder) {
            this.name = name;
            this.isFolder = isFolder;
        }
    }
}
