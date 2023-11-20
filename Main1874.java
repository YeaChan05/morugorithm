import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        scanner.close();

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int current = 1;

        for (int num : sequence) {
            while (current <= num) {
                stack.push(current);
                result.append("+\n");
                current++;
            }

            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(result.toString());
    }
}
