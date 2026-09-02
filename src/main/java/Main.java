
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("$: ");
            String input = br.readLine();
            if (input == null) {
                break;
            } else if (input.equals("exit")) {
                break;
            } else if (input.startsWith("echo ") || input.equals("echo")) {
                if(input.length() == 4) {
                    System.out.println();
                } else {
                    System.out.println(input.substring(5));
                }
            }
        }
        br.close();
    }
}
