import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] cardSet = new int[9];

        for(int i = 0 ; i < arr.length ; i++) {
            int num = arr[i] - '0';
            if(num == 9 || num == 6) {
                cardSet[6]++;
            } else {
                cardSet[num]++;
            }
        }

        cardSet[6] = (cardSet[6] + 1) / 2;
        int max = -1;
        
        for(int i = 0 ; i < 9 ; i++) {
            max = Math.max(max, cardSet[i]);
        }
        System.out.println(max);
    }
}
