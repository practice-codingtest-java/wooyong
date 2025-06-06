
# ✅ 6주차 ( Dynamic Programming )

- 메모리를 적절히 사용하여 **수행 시간 효율성**을 비약적으로 향상시키는 방법
- 이미 계산된 결과는 **별도의 메모리 영역에 저장**하여 다시 계산하지 않도록 함
- 구현은 일반적으로 두가지 방식으로 구성되고 전형적인 형태는 **Bottom-up** 방식!
  - `Top-down` : 큰 부분 -> 작은 부분, **재귀함수**로 구현  ex)모든 부분을 다 구하지 않아도 될 때
  - `Bottom-up` : 작은 부분 -> 큰 부분, **반복문**으로 구현

주어진 문제가 **DP 유형임을 파악**하는 것이 중요!
먼저 **그리디, 구현, 완전 탐색** 등의 아이디어로 해결할 수 있는지 검토 -> 떠오르지 않으면 DP 고려

## 📝 Common, Private

- [동전 2](https://www.acmicpc.net/problem/2294)
  - Bottom-up DP 대표문제 -> 다시 풀어볼 것
  - 이전 코인이 MAX_VALUE(초기값)인지 비교하여 패스하는 부분 주의
- [연속합](https://www.acmicpc.net/problem/1912)
  - 반복문을 이용한 Bottom-up 방법
- [평범한 배낭](https://www.acmicpc.net/problem/12865)
- [계단 오르기](https://www.acmicpc.net/problem/2579)
	```java  
	//뒤에서부터 순회 -> 같은 물건 한 번만 사용 (중복 금지)
	for (int j = k; j >= 0; j--) {  
	    if (j >= p.weight) {  
	        dp[j] = Math.max(dp[j], dp[j - p.weight] + p.value);  
	    }  
	}  

	//앞에서부터 순회 -> 같은 물건 여러 번 사용 가능 (중복 허용)
	for (int j = 0; j <= k; j++) {  
	    if (j >= p.weight) {  
	        dp[j] = Math.max(dp[j], dp[j - p.weight] + p.value);  
	    }  
	} 
	```
	- **Knapsack Problem**: 매우 유명한 DP 문제
	- 앞에서 부터 순회를 해서 중복으로 인해 계속 반례가 생겼었음 -> 다시 풀어볼 것!
- [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
  - 반복문을 이용한 Bottom-up 방법
- [가장 긴 감소하는 부분 수열](https://www.acmicpc.net/problem/11722)
