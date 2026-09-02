
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
            }
            if (!input.isEmpty()) {
                System.out.println("You entered: " + input);
            }
        }
    }
}
