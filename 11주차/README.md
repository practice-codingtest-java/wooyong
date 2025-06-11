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
- [트리의 지름](https://www.acmicpc.net/problem/1167)
- [저울](https://www.acmicpc.net/problem/2437)
- [사전 순 최대 공통 부분 수열](https://www.acmicpc.net/problem/30805)
