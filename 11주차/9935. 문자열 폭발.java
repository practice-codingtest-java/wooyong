import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String bomb = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));

            if (stack.size() >= bomb.length() && word.charAt(i) == bomb.charAt(bomb.length() - 1)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0 ; j < bomb.length(); j++) {
                    sb.append(stack.pop());
                }

                if (!sb.reverse().toString().equals(bomb)) {
                    for (int j = 0; j < sb.length(); j++) stack.push(sb.charAt(j));
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());

        System.out.println(result.reverse().toString());
    }
}
