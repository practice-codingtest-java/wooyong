# ✅ 11주차 ( 각 주차 복습 )

## 📝 Common, Private

- [구슬 탈출](https://www.acmicpc.net/problem/13460)
  ```java
  for (int i = 0; i < 4; i++) {
  	int nx = node.x, ny = node.y;
  	while (true) {
      nx += dx[i];
      ny += dy[i];
      
      if (matrix[nx][ny] == '#') {
  	    nx -= dx[i];
        ny -= dy[i];
        break;
      }
      //nx,ny는 벽에 부딪히기 전의 좌표
  	}
  }
  ```
  - 벽(#)이 나올 때까지 상, 하, 좌, 우로 이동하는 것이 중요
  - blue, red 공의 위치를 각각 queue에 넣는 것이 아니라 동시의 위치를 queue 저장
- [세 수의 합](https://www.acmicpc.net/problem/2295)
  - 이분 탐색으로 특정 값 존재 유무 확인하는 문제, **set**의 `contains`으로도 풀 수 있음
- [탑 보기](https://www.acmicpc.net/problem/22866)
- [베스트 앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579)
- [문자열 폭발](https://www.acmicpc.net/problem/9935)
  - `Deque`를 스택처럼 쓸 때 `push()`는 `addFirst()`, `pop()`은 'removeFirst()`로 맨 앞의 값을 추가/삭제한다는 것을 생각
  - `String`은 문자열을 조작할 때마다 새로운 객체를 생성하기 때문에 이런 경우에는 `StringBuilder` 사용
  
  ```java
  StringBuilder sb = new StringBuilder();
  sb.append(...);  //문자 추가
  System.out.println(result.reverse().toString());  //문자열 뒤집기, 출력
  if (!sb.reverse().toString().equals(bomb)) {
      for (int j = 0; j < sb.length(); j++) stack.push(sb.charAt(j));
  }
  ```
- [트리의 지름](https://www.acmicpc.net/problem/1167)
- [저울](https://www.acmicpc.net/problem/2437)
- [사전 순 최대 공통 부분 수열](https://www.acmicpc.net/problem/30805)
