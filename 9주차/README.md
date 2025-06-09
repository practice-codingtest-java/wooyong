


# ✅ 9주차 ( 그리디 )

- **부분적인 최적 해가 전체적인 최적 해**가 되는 문제에서 사용한다.
- 어렵게 출제되면 풀이를 쉽게 떠올리기 힘드니, 문제를 많이 풀어보면서 풀이 방법을 기억하자.
- **정렬**, **우선순위 큐**를 활용하는 경우가 많다.
- 예) [프로그래머스 - 큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)
  ![](https://velog.velcdn.com/images/pppp0722/post/b71a33b6-d4b0-4f24-8b41-711b44f36517/image.png)

## 📝 Common, Private

- [배](https://www.acmicpc.net/problem/1092)
  ```java
  Integer[] crane = new Integer[n];
  Arrays.sort(crane, Collections.reverseOrder());
  ```
  - **Array 내림차순** 정렬
  - int, char, long 같은 원시 타입 배열에는 적용 불가능
- [카드 정렬하기](https://www.acmicpc.net/problem/1715)
  - 그리디 + `PriorityQueue`
  ```java
  //queue와 사용방법 똑같음 offer, poll, peek
  //기본적으로는 최소 힙(min-heap) 으로 동작하여 숫자 기준으로는 작은 값이 우선순위가 높아 먼저 나옴
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
  }
  ```
  - pq 안에 최소 2개가 있을 때 2개를 꺼낼 수 있으므로 `while (!pq.isEmpty())` 말고
  ```java
  while (pq.size() > 1) {  
    //
  }
  ```
- [주식](https://www.acmicpc.net/problem/11501)
  - 규칙 찾은 후 **역방향 탐색**
- [선 긋기](https://www.acmicpc.net/problem/2170)
  ```java
  List<Node> list = new ArrayList<>();
  list.sort((a, b) -> a.x - b.x);
  ```
  - Node 클래스의 x 변수 기준으로 오름차순 정렬

- [MST 게임](https://www.acmicpc.net/problem/16202)
  - MST 구하기 -> `Kruskal` vs `Prim` : 간선을 제거하면서 구해야 하므로 **Kruskal**이 좋음
- [잃어버린 괄호](https://www.acmicpc.net/problem/1541)
  ```java
  String[] numArr = str.split("\\+|-");
  ```
  - 여러 개의 구분자(-, +)로 문자열 자르기
  - `+`는 정규표현식에서 **특수문자**이기 때문에 **리터럴 문자로 인식**시키기 위해 `\\`를 써야됨
  ```java
  int[] numArr = Arrays.stream(str.split("\\+|-"))  
          .mapToInt(Integer::parseInt)  
          .toArray();
  ```
  - **Stream**을 이용하여 `String[]` -> `int[]`로 바로 변환
