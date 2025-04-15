import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                stack.push(x);
            } else if (input.equals("pop")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.pop());
            } else if (input.equals("size")) {
                System.out.println(stack.size());
            } else if (input.equals("empty")) {
                System.out.println(stack.isEmpty() ? "1" : "0");
            } else if (input.equals("top")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.peek());
            }
        }
    }
}
