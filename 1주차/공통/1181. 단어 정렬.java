import java.io.*;
import java.util.*;

class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() != o2.length()) {
            return o1.length() - o2.length();
        } else {
            return o1.compareTo(o2);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //TreeSet: 중복 허용 X, 이진탐색트리 형태로 데이터 저장, 정렬 O
        Set<String> words = new TreeSet<>(new CustomComparator());

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
