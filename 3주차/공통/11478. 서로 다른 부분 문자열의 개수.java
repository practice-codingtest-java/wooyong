import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;
        Set<String> hs = new HashSet<>();

        for(int i = 0 ; i < str.length() ; i++) {
            for(int j = i + 1 ; j <= str.length() ; j++) {
                hs.add(str.substring(i, j));
            }
        }

        System.out.println(hs.size());
    }
}
