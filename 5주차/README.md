# ✅ 4주차 ( DFS, BFS 심화 )

## 📝 Common, Private

- [불!](https://www.acmicpc.net/problem/4179)
  - 고정된 fire 먼저 bfs 후에 지훈 bfs
  - bfs를 따로 돌리기 때문에 visited 배열 대신 시간 저장
- [하이퍼 토마토](https://www.acmicpc.net/problem/17114)
- [텀 프로젝트](https://www.acmicpc.net/problem/9466)
  - 자료구조 전체 요소 삭제 -> `Collection` 인터페이스 `clear()` 구현
	```java
	list.clear();  //ArrayList, LinkedList
	set.clear();  //HashSet, TreeSet
	map.clear();  //HashMap, TreeMap
	queue.clear();  //ArrayDequeue, LinkedList
	stack.clear();  //Stack
	
	Arrays.fill(배열, 값);  //array
	```
    - **array**는 `Arrays.fill()` 사용

- [2048 (Easy)](https://www.acmicpc.net/problem/12100)
- [폴더 정리 (small)](https://www.acmicpc.net/problem/22860)
  - **split**으로 문자열 추출
	 ```java
	String path = "main/FolderB/FolderC";
	String[] parts = path.split("/");

	// 마지막 요소 가져오기
	String last = parts[parts.length - 1];
	System.out.println(last);  // FolderC
	```
  - **String key**로 여러 **value** 연결
	```java
	static Map<String, List<Node>> map = new HashMap<>();  
	  
	public static void main(String[] args) throws IOException {  
		//...
	    for (int i = 0; i < n + m; i++) {  
	        //...  
	        if (!map.containsKey(x)) map.put(x, new ArrayList<>());  
	        map.get(x).add(new Node(y, Integer.parseInt(c)));  
	    }
	    //...
	}
	```  
- [벽 부수고 이동하기 3](https://www.acmicpc.net/problem/16933)
