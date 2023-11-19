import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {
    private static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) {
        setStack();
    }

    private static void setStack() {
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                int result = Integer.parseInt(br.readLine());
                computeResult(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void computeResult(int result) {
        while (result>stack.size()){
            stack.push(0);
            System.out.println("+");
        }
        while (result!=stack.size()){
            stack.pop();
            System.out.println("-");
        }
    }
}
