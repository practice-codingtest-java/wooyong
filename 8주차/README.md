# ✅ 8주차 ( 이분탐색 )

## 📝 Common, Private

- [랜선 자르기](https://www.acmicpc.net/problem/1654)
  - start를 0으로 시작하면 mid가 0이 될 수 있는 문제 -> count += (arr[i] / mid)에서 error -> start 1로 시작
- [공유기 설치](https://www.acmicpc.net/problem/2110)
  - 설치 수 count 구현할 때, arr.length 한번이면 됨
  - 두 공유기 사이의 거리를 기준으로 이분탐색
- [개똥벌레](https://www.acmicpc.net/problem/3020)
- [게임](https://www.acmicpc.net/problem/1072)
  - 해야하는 게임수를 기준으로 이분탐색 
- [나무 자르기](https://www.acmicpc.net/problem/2805)
  - binarySearch에서 mid return X, result 변수 선언
  - 어쨋든 **sum > target일 때만 정답**이기 때문에 해당 조건일 때 계속 mid를 result에 뒤집어씌우기
- [K번째 수](https://www.acmicpc.net/problem/1300)
