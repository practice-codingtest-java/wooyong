# ✅ 3주차 ( 해시 )

## 📝 Common

### 해시, 트리
- [학생 인기도 측정](https://www.acmicpc.net/problem/25325)
  - value 기준 정렬 `HashMap`, `TreeMap`(key 정렬만 가능)으로는 불가능 -> entrySet()을 list로 바꿔 정렬
- [서로 다른 부분 문자열의 개수](https://www.acmicpc.net/problem/11478)
- [대칭 차집합](https://www.acmicpc.net/problem/1269)
  - `setA.removeAll(setB)`: setB에 포함된 모든 요소를 setA에서 **제거** → 즉, A - B 연산
  - `setA.addAll(setB)`: setB에 포함된 모든 요소를 setA에 복사해서 **추가**
- [수 찾기](https://www.acmicpc.net/problem/1920)
- [차집합](https://www.acmicpc.net/problem/1822)
  - `HashSet` : 순서 보장 X
  - `TreeSet`: 오름차순 정렬해서 저장
  - `LinkedHashSet`: 입력한 순서대로 저장
  - 증가하는 순서로 출력 -> **TreeSet**
- [에너그램 만들기](https://www.acmicpc.net/problem/1919)
  - `a.charAt(index)`: String a에 대한 index접근
  - `for (char ch : mapA.keySet())` : HashMap key 값 순회

## 📝 Private

### 해시, 트리
- [트리](https://www.acmicpc.net/problem/1068)
- [친구 네트워크](https://www.acmicpc.net/problem/4195)
- [패션왕 신해빈](https://www.acmicpc.net/problem/9375)
- [비슷한 단어](https://www.acmicpc.net/problem/2179)
- [마니또](https://www.acmicpc.net/problem/5107)
- [k번째 큰수](https://github.com/practice-codingtest-java/wooyong/blob/main/3%EC%A3%BC%EC%B0%A8/%EA%B0%9C%EC%9D%B8/README.md)
  - `Set<Integer> set = new TreeSet<>(Collections.reverseOrder())`: TreeSet 내림차순 정렬
  - 정렬된 TreeSet을 ArrayList로 변환 가능 -> `List<Integer> list = new ArrayList<>(set)`

