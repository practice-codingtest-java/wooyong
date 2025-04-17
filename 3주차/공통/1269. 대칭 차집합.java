import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setTemp = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        //setA.removeAll(setB): setB에 포함된 모든 요소를 setA에서 제거 → 즉, A - B 연산
        //setA.addAll(setB): setB에 포함된 모든 요소를 setA에 복사해서 추가
        setTemp.addAll(setA);
        setA.removeAll(setB);
        setB.removeAll(setTemp);

        System.out.println(setA.size() + setB.size());
    }
}
