import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // - 나오기 전까지의 모든 수는 더하고 후의 모든 수는 빼기
        int[] numArr = Arrays.stream(str.split("\\+|-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Character> signList = new ArrayList<>();

        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') signList.add(c);
        }

        int plusSum = numArr[0];
        int minusSum = 0;

        for (int i = 0; i < signList.size(); i++) {
            if (signList.get(i) == '+') {
                plusSum += numArr[i+1];
            } else if (signList.get(i) == '-') {
                for (int j = i + 1; j < numArr.length; j++) {
                    minusSum += numArr[j];
                }
                break;
            }
        }
        System.out.println(plusSum - minusSum);
    }
}
