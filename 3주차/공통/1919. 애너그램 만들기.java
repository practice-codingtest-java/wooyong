import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int count = 0;

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        //`a.charAt(index)`: String a에 대한 index접근
        for(int i = 0; i < a.length(); i++){
            char key = a.charAt(i);
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < b.length(); i++){
            char key = b.charAt(i);
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }

        //`for (char ch : mapA.keySet())` : HashMap key 값 순회
        for (char ch : mapA.keySet()) {
            int countA = mapA.get(ch);
            int countB = mapB.getOrDefault(ch, 0);
            count += Math.abs(countA - countB);
            mapB.remove(ch);
        }

        for (char ch : mapB.keySet()) {
            count += mapB.get(ch);
        }
        System.out.println(count);
    }
}
