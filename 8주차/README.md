# ✅ 8주차 ( 이분탐색 )

## 📝 Common, Private

- [랜선 자르기](https://www.acmicpc.net/problem/1654)
  - start를 0으로 시작하면 mid가 0이 될 수 있는 문제 -> count += (arr[i] / mid)에서 error -> start 1로 시작
- [공유기 설치](https://www.acmicpc.net/problem/2110)
  - 설치 수 count 구현할 때, arr.length 한번이면 됨
  - 두 공유기 사이의 거리를 기준으로 이분탐색
- [개똥벌레](https://www.acmicpc.net/problem/3020)
  - 누적합 -> how 이분탐색?
- [게임](https://www.acmicpc.net/problem/1072)
  - 해야하는 게임수를 기준으로 이분탐색 
- [나무 자르기](https://www.acmicpc.net/problem/2805)
  - binarySearch에서 mid return X, result 변수 선언
  - 어쨋든 **sum > target일 때만 정답**이기 때문에 해당 조건일 때 계속 mid를 result에 뒤집어씌우기
  - 아래 이분탐색 방식으로도 풀어볼 것
  |방식|설명|예|
  |------|---|---|
  |값을 기준으로|key와 배열 값 비교|target이 어디에 있는가|
  |인덱스를 찾는 이분 탐색 (lowerBound)|특정 조건을 처음 만족하는 **인덱스**를 찾기|i 이상인 값의 시작 인덱스|
  
  높이 i에 대해 높이가 i 이상/이하인 장애물 개수를 이분 탐색
  -> 높이가 i 이상/이하인 시작 인덱스를 찾는 것!!
  ```java
  private static int lowerBound(int[] arr, int key) {
      int left = 0;
      int right = arr.length; // 범위는 인덱스 기준
  
      while (left < right) {
          int mid = (left + right) / 2;
          if (arr[mid] < key) {  // 일반 mid가 아닌 arr[mid]인 것이 중요!!
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      return left; // key 이상이 처음 등장하는 인덱스
  }
  ```
- [K번째 수](https://www.acmicpc.net/problem/1300)
  - 이분탐색의 기준 잡기가 어려웠음 B[k] = x에서 주어지지 않은 x를 기준으로 잡아야됨
  - 2, 4, 6, 8, 10에서 5보다 같거나 작은수 -> N의 시간복잡도로 풀어야됨
  ```java
  //i=2(i의 배수), mid=5, n=5(1~5)
  for (int i = 1; i <= n; i++) {
    cnt += Math.min(n, mid / i);
  }
  ```
