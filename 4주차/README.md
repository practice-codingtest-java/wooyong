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

### 2차원 배열(미로) 문제
- [미로 탐색](https://www.acmicpc.net/problem/2178)
  - 좌표 + 거리 등 여러 정보 클래스 `Node` 
  - 좌표만 `Point`
  - 101111 문자열 받아서 in[][] matrix 배열로 받기
- [유기농 배추](https://www.acmicpc.net/problem/1012)
- [단지번호붙이기](https://www.acmicpc.net/problem/2667)
  - 정렬한다고 무조건 `Set`쓰는 것은 아님 -> 값이 중복되는 경우에는 `ArrayList`에 저장 후 `Collection.sort(list)`
- [헌내기는 친구가 필요해](https://www.acmicpc.net/problem/21736)



- [효율적인 해킹](https://www.acmicpc.net/problem/1325)
- [나이트의 이동](https://www.acmicpc.net/problem/7562)
- [토마토](https://www.acmicpc.net/problem/7576)
- [치킨배달](https://www.acmicpc.net/problem/15686)
