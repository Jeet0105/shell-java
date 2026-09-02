
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
            } else if (input.startsWith("type ") || input.equals("type")) {
                if(input.length() == 4) {
                    System.out.println("type: missing argument");
                    continue;
                }
                if(!type(input.substring(5))) {
                    System.out.println(input.substring(5) + ": not found");
                } else {
                    System.out.println(input.substring(5) + ": is a shell builtin");
                }
            } else {
                System.out.println(input + ": not found");
            }
        }
        br.close();
    }

    static boolean type(String cmd) {
        String[] BUILDIN = {"echo", "exit", "type"};
        for (String b : BUILDIN) {
            if (cmd.equals(b)) {
                return true;
            }
        }
        return false;
    }
}
