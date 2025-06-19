# ✅ 12주차 ( 구현 )

## 📝 Common, Private

- [⚾️](https://www.acmicpc.net/problem/17281)
- [LCS 2](https://www.acmicpc.net/problem/9252)
	- 최장 공통 부분 수열 (길이, 찾기), 최장 공통 문자열
	> [그림으로 알아보는 LCS 알고리즘 - Longest Common Substring와 Longest Common Subsequence](https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence#%EC%B5%9C%EC%9E%A5-%EA%B3%B5%ED%86%B5-%EB%AC%B8%EC%9E%90%EC%97%B4longest-common-substring)
- [이모티콘 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/150368)
- [주사위굴리기](https://www.acmicpc.net/problem/23288)
- [합승 택시 요금](https://school.programmers.co.kr/learn/courses/30/lessons/72413)  
 	**다익스트라 알고리즘**: 그래프에서 여러 개의 노드가 있을 때 **특정 노드**에서 **다른 노드**로 가는 각각의 최단 경로를 구해주는 알고리즘
	```java
	import java.io.*;
	import java.util.*;
	
	public class Main { ;
	
	    private static List<List<Node>> graph = new ArrayList<>();
	    private static int[] dist;
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	
	        int v = Integer.parseInt(st.nextToken());  //정점수
	        int e = Integer.parseInt(st.nextToken());  //간선수
	        int start = Integer.parseInt(st.nextToken());  //시작 정점
	
	        dist = new int[v + 1];
	
	        for (int i = 0; i <= v; i++) {
	            graph.add(new ArrayList<>());
	            dist[i] = Integer.MAX_VALUE;
	        }
	
	        for (int i = 0; i < e; i++) {
	            st = new StringTokenizer(br.readLine());
	            int from = Integer.parseInt(st.nextToken());
	            int to = Integer.parseInt(st.nextToken());
	            int cost = Integer.parseInt(st.nextToken());
	            graph.get(from).add(new Node(to, cost));
	        }
	
	        dijkstra(start);
	
	        for (int i = 1; i <= v; i++) {
	            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
	            else System.out.println(dist[i]);
	        }
	    }
	
	    private static void dijkstra(int start) {
	        PriorityQueue<Node> pq = new PriorityQueue<>(
	                (o1, o2) -> o1.cost - o2.cost
	        );
	        dist[start] = 0;
	        pq.offer(new Node(start, 0));
	
	        while (!pq.isEmpty()) {
	            Node current = pq.poll();
	
	            if (dist[current.vertex] < current.cost) continue;
	
	            for (Node next : graph.get(current.vertex)) {
	                int nextCost = current.cost + next.cost;
	
	               if (nextCost < dist[next.vertex]) {
	                   dist[next.vertex] = nextCost;
	                   pq.offer(new Node(next.vertex, nextCost));
	               }
	            }
	        }
	    }
	
	    private static class Node {
	        int vertex;
	        int cost;
	
	        public Node(int vertex, int cost) {
	            this.vertex = vertex;
	            this.cost = cost;
	        }
	    }
	}
	```  
