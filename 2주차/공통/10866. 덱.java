import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.startsWith("push_front")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                arrayDeque.offerFirst(x);
            } else if (input.startsWith("push_back")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                arrayDeque.offerLast(x);
            } else if (input.equals("pop_front")) {
                System.out.println(arrayDeque.isEmpty() ? "-1" : arrayDeque.pollFirst());
            } else if (input.equals("pop_back")) {
                System.out.println(arrayDeque.isEmpty() ? "-1" : arrayDeque.pollLast());
            } else if (input.equals("size")) {
                System.out.println(arrayDeque.size());
            } else if (input.equals("empty")) {
                System.out.println(arrayDeque.isEmpty() ? "1" : "0");
            } else if (input.equals("front")) {
                System.out.println(arrayDeque.isEmpty() ? "-1" : arrayDeque.peekFirst());
            } else if (input.equals("back")) {
                System.out.println(arrayDeque.isEmpty() ? "-1" : arrayDeque.peekLast());
            }
        }
    }
}
