import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                if (input.charAt(i + 1) == ')') {
                    i++;
                    result += stack.size();
                } else {
                    stack.push(c);
                }
            } else if (c == ')') {
                stack.pop();
                result++;
            }
        }
        System.out.println(result);
    }
}
