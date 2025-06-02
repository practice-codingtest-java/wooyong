
# ✅ 9주차 ( 그리디 )

- **부분적인 최적 해가 전체적인 최적 해**가 되는 문제에서 사용한다.
- 어렵게 출제되면 풀이를 쉽게 떠올리기 힘드니, 문제를 많이 풀어보면서 풀이 방법을 기억하자.
- **정렬**, **우선순위 큐**를 활용하는 경우가 많다.
- 예) [프로그래머스 - 큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)
  ![](https://velog.velcdn.com/images/pppp0722/post/b71a33b6-d4b0-4f24-8b41-711b44f36517/image.png)

## 📝 Common, Private

- [배](https://www.acmicpc.net/problem/1092)
- [카드 정렬하기](https://www.acmicpc.net/problem/1715)
- [주식](https://www.acmicpc.net/problem/11501)
  - 규칙 찾은 후 **역방향 탐색**
- [선 긋기](https://www.acmicpc.net/problem/2170)
- [MST 게임](https://www.acmicpc.net/problem/16202)
- [잃어버린 괄호](https://www.acmicpc.net/problem/1541)
  ```java
  String[] numArr = str.split("\\+|-");
  ```
  - 여러 개의 구부자로 문자열 자르기

  ```java
  int[] numArr = Arrays.stream(str.split("\\+|-"))  
          .mapToInt(Integer::parseInt)  
          .toArray();
  ```
  - **Stream**을 이용하여 `String[]` -> `int[]`로 바로 변환
