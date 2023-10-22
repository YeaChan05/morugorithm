import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main10828 {
    public static List<String> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String commandLine = br.readLine();
            String message = commandLine.split(" ")[0];
            Command.valueOf(message).calc(commandLine);
        }
    }

    enum Command {
        push() {
            @Override
            public void calc(String commandLine) {
                stack.add(commandLine.split(" ")[1]);
            }
        },
        pop() {
            @Override
            public void calc(String commandLine) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.remove(stack.size() - 1));
                }
            }
        },
        size() {
            @Override
            public void calc(String commandLine) {
                System.out.println(stack.size());
            }
        },
        empty() {
            @Override
            public void calc(String commandLine) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        },
        top() {
            @Override
            public void calc(String commandLine) {
                System.out.println(!stack.isEmpty() ? stack.get(stack.size() - 1) : -1);
            }
        };

        public abstract void calc(String commandLine);
    }
}
