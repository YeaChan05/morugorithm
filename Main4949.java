import java.util.*;
import java.util.stream.Collectors;

public class Main4949 {
    public static void main(String[] args) {
        List<String> messages = inputLines();
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            if (isBalenced(message))
                sb.append("yes\n");
            else sb.append("no\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static boolean isBalenced(String message) {
        char[] charArray = message.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '[')
                stack.push(c);
            else if (c==']') {
                if(!stack.isEmpty()&&stack.peek().equals('['))
                    stack.pop();
                else
                    stack.push(c);
            }
            else if (c==')') {
                if(!stack.isEmpty()&&stack.peek().equals('('))
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    private static List<String> inputLines() {
        String message = "";
        List<String> messages = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                message = getMessage(scanner, messages);
            } while (message != null);
            return messages;
        }
    }

    private static String getMessage(Scanner scanner, List<String> messages) {
        String message;
        message = scanner.nextLine();
        if (message.equals("."))
            return null;
        StringBuilder stringBuilder = new StringBuilder(message);
        stringBuilder.deleteCharAt(message.length() - 1);
        message = stringBuilder.toString();
        messages.add(message);
        return message;
    }

}
