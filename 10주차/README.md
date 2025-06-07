# ✅ 10주차 ( 최소 스패닝 트리 )

`스패닝 트리(Spanning Tree)`: **모든 정점을 포함**하는 **사이클 없는** 트리  
`최소 신장 트리(Minimum Spanning Tree)` 무방향 연결 그래프에서 **모든 정점을 연결하는 부분 그래프** 중, **간선의 가중치 합이 최소**인 트리

**<MST를 구하는 알고리즘 2가지>**

<img width="287" alt="mst" src="https://github.com/user-attachments/assets/164c4488-16c1-4152-bae1-ce0cc8507e71" />

`MST 총 가중치: 159`

***1. Kruskal 알고리즘***
```java
import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;  //같은 집합이면 사이클 발생

        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());  //정점
        int E = Integer.parseInt(st.nextToken());  //간선

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        //weight 기준으로 오름차순 정렬
        Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);

        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {  //사이클 방지
                totalWeight += edge.weight;
                edgeCount++;
                if (edgeCount == V - 1) break; //MST 완성
            }
        }

        System.out.println("MST 총 가중치: " + totalWeight);
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
```
-   간선을 **가중치 오름차순**으로 정렬한 후,  사이클을 만들지 않는 간선만 선택
-   **Union-Find(Disjoint Set)** 자료구조를 사용해서 사이클 방지

***2. Prim 알고리즘***
```java
class Node implements Comparable<Node> {
    int to, weight;
    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
```
-   하나의 정점에서 시작해서, **가장 비용이 적은 간선**을 계속 선택하여 확장
-   **PriorityQueue**를 이용해 구현
-   Kruskal은 **간선을 기준**으로, Prim은 **정점을 기준**으로 동작

**Kruskal vs Prim**
|상황|추천 알고리즘|
|---|---|
|간선이 적은 경우 (희소 그래프)|Kruskal|
|간선이 많은 경우 (밀집 그래프)|Prim|
|정점 개수가 많고 간선 입력이 빠르게 주어지면|Prim + 인접 리스트|
|정점이 많지 않고 간선이 정렬되거나 거의 정렬된 경우|Kruskal|

## 📝 Common, Private

- [도시 분할 계획](https://www.acmicpc.net/problem/1647)
- [다리 만들기 2](https://www.acmicpc.net/problem/17472)
