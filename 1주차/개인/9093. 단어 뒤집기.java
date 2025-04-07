import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < input.length; i++) {
                StringBuilder reverse = new StringBuilder(input[i]).reverse();
                System.out.print(reverse + " ");
            }
        }
    }
}
