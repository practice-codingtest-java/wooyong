
# ✅ 2주차 ( 스택 큐 )

## 📝 Common

- [스택](https://www.acmicpc.net/problem/10828)
- [큐](https://www.acmicpc.net/problem/10845)
- [덱](https://www.acmicpc.net/problem/10866)

## 📝 Private

- [쇠막대기](https://www.acmicpc.net/problem/10799)
	`()(((()())(())()))(())` 문자열 다루기
	 
	```java
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();

	// 방법 1: toCharArray() 사용 -> array 변환
	char[] arr = line.toCharArray();

	// 방법 2: charAt(i) 사용 -> String 그대로
	for (int i = 0; i < line.length(); i++) {
	    char ch = line.charAt(i);
	}
	```
- [강의실 배정](https://www.acmicpc.net/problem/11000)
- [뱀](https://www.acmicpc.net/problem/3190)
