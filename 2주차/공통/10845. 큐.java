import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                queue.offer(x);
            } else if (input.equals("pop")) {
                System.out.println(queue.isEmpty() ? "-1" : queue.poll());
            } else if (input.equals("size")) {
                System.out.println(queue.size());
            } else if (input.equals("empty")) {
                System.out.println(queue.isEmpty() ? "1" : "0");
            } else if (input.equals("front")) {
                System.out.println(queue.isEmpty() ? "-1" : queue.peek());
            } else if (input.equals("back")) {
                System.out.println(queue.isEmpty() ? "-1" : queue.peekLast());
            }
        }
    }
}
