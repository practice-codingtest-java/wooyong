# ✅ 7주차 ( Dynamic Programming 심화 )

## 📝 Common, Private

- [색상환](https://www.acmicpc.net/problem/2482)
- [파일 합치기](https://www.acmicpc.net/problem/11066)
- [사회망서비스(sns)](https://www.acmicpc.net/problem/2533)
- [가장 긴 증가하는 부분 수열 4](https://www.acmicpc.net/problem/14002)
	```java
	ArrayList<Integer> copied = new ArrayList<>(map.get(maxIndex));  
	copied.add(arr[i]);  
	map.put(arr[i], copied);
	```
	- 기존 리스트의 내용을 **깊은 복사** (실제 값을 새로운 메모리 공간에 복사) -> 초기화도 같이
	-  복사본에 값 추가하여 **원본 리스트는 변경하지 않고**, 복사본에만 값을 추가할 수 있음
	-  4 \n 3 2 7 7 -> 초기 코드에서는 초기화가 없어서 NullPointException 떴었음 -> map에서 ArrayList 쓸 때는 항상 초기화 생각

- [외판원 순회](https://www.acmicpc.net/problem/2098)
- [행렬 곱셈 순서](https://www.acmicpc.net/problem/11049)
