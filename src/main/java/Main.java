import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.print("$: ");

            String input = br.readLine();

            // EOF
            if (input == null) {
                break;
            }

            // exit
            if (input.equals("exit")) {
                break;
            }

            // echo
            else if (input.startsWith("echo ") || input.equals("echo")) {

                if (input.equals("echo")) {
                    System.out.println();
                } else {
                    System.out.println(input.substring(5));
                }
            }

            // type
            else if (input.startsWith("type ") || input.equals("type")) {

                if (input.equals("type")) {
                    System.out.println("type: missing argument");
                    continue;
                }

                String command = input.substring(5);

                if (!type(command)) {
                    System.out.println(command + ": not found");
                } else {
                    System.out.println(command + " is a shell builtin");
                }
            }

            // External command
            else {
                executeProgram(input);
            }
        }

        br.close();
    }

    static boolean type(String cmd) {

        String[] BUILTINS = {
                "echo",
                "exit",
                "type"
        };

        for (String builtin : BUILTINS) {
            if (cmd.equals(builtin)) {
                return true;
            }
        }

        return false;
    }

    static void executeProgram(String cmd) {

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));

            Process process = pb.start();

            // Read stdout while the process is running
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait until process finishes
            process.waitFor();

            reader.close();

        } catch (IOException e) {
            System.out.println(cmd + ": command not found");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}