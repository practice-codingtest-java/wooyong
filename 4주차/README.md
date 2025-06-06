# ✅ 4주차 ( DFS, BFS )

## 📝 Common, Private

### 그래프(트리 포함) 문제
- [바이러스](https://www.acmicpc.net/problem/2606)
  - `dfs`
- [DFS와 BFS](https://www.acmicpc.net/problem/1260)
  - 그래프의 각 노드의 인접 노드 리스트를 `정렬된 상태`로 유지하고 싶다!!
    - TreeSet  사용: `static ArrayList<TreeSet<Integer>> graph = new ArrayList<>()` -> TreeSet은 인덱스 접근이 불가능 하므로, 향상된 for문으로 순회
    - ArrayList + 정렬: `Collections.sort(graph.get(x))`
- [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
  - `dfs`
- [나무 탈출](https://www.acmicpc.net/problem/15900)
  - `bfs`
- [효율적인 해킹](https://www.acmicpc.net/problem/1325)
  - `Arrays.fill(visited, false)` : 배열 false로 초기화
  - dfs 자식 노드의 cnt 값 반환하면서 더하기
  - dfs로 풀어서 시간 초과 나면 bfs로 바꿔서 풀 생각도 해보자

### 2차원 배열(미로) 문제
- [미로 탐색](https://www.acmicpc.net/problem/2178)
  - 좌표 + 거리 등 여러 정보 클래스 `Node` 
  - 좌표만 `Point`
  - 101111 문자열 받아서 in[][] matrix 배열로 받기
- [유기농 배추](https://www.acmicpc.net/problem/1012)
- [단지번호붙이기](https://www.acmicpc.net/problem/2667)
  - 정렬한다고 무조건 `Set`쓰는 것은 아님 -> 값이 중복되는 경우에는 `ArrayList`에 저장 후 `Collection.sort(list)`
- [헌내기는 친구가 필요해](https://www.acmicpc.net/problem/21736)
- [나이트의 이동](https://www.acmicpc.net/problem/7562)
- [토마토](https://www.acmicpc.net/problem/7576)
  - `bfs` 시작점이 여러개 -> 자료구조에 시작점 받고 큐에 한번에 넣기

### 그 외
- [치킨배달](https://www.acmicpc.net/problem/15686)
  - 백트래킹을 이용한 조합 -> for문 계산
  - `List<Node> selected`를 매서드 매개변수로 넣어서 요소 추가하면서 계산
  - 최소값 구할 때 `int min = Integer.MAX_VALUE;`
