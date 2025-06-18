import java.io.*;
import java.util.*;

public class Main { ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        int str1Length = str1.length();

        String str2 = br.readLine();
        int str2Length = str2.length();

        //LCS 길이 구하기
        int[][] LCS = new int[str1Length + 1][str2Length + 1];
        for (int i = 1 ; i <= str1Length ; i++) {
            for (int j = 1 ; j <= str2Length ; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) LCS[i][j] = LCS[i - 1][j - 1] + 1;
                else LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
            }
        }

        //역추적을 통해 LCS 찾기
        int i = str1Length, j = str2Length;
        List<Character> result = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (LCS[i][j] == LCS[i-1][j]) i--;
            else if (LCS[i][j] == LCS[i][j-1]) j--;
            else {
                i--;
                j--;
                result.add(str1.charAt(i));
            }
        }
        Collections.reverse(result);

        System.out.println(result.size());
        for (char c : result) System.out.print(c);
    }
}
