import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String input = br.readLine();
            if(input.equals("0")){
                break;
            }

            StringBuilder num = new StringBuilder(input);
            StringBuilder revNum = new StringBuilder(input).reverse();

            if (num.toString().equals(revNum.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
