import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Deque<String> stack = new ArrayDeque<>();
            String pts = br.readLine();

            for (int j = 0; j < pts.length(); j++) {
                char c = pts.charAt(j);
                if(c == '(') {
                    stack.push("(");
                } else if(c == ')') {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push(")");
                        break;
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
