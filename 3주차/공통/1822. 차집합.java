import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new TreeSet<>();
        Set<Integer> setB = new HashSet<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < a ; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < b ; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        setA.removeAll(setB);
        System.out.println(setA.size());

        if (!setA.isEmpty()) {
            for (Integer i : setA) {
                System.out.print(i + " ");
            }
        }
    }
}
