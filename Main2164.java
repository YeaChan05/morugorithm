import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main2164 {
    public static void main(String[] args) throws IOException {
        int N = input();
        Deque<Integer> deque = setDeque(N);
        int done = doShuffle(deque);
        System.out.println(done);
    }

    private static int doShuffle(Deque<Integer> deque) {
        while (deque.size() > 1) {
            deque.removeLast();
            Integer top = deque.removeLast();
            deque.addFirst(top);
        }
        return deque.removeFirst();
    }

    private static Deque<Integer> setDeque(int n) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            deque.addLast(i);
        }
        return deque;
    }

    private static int input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(br.readLine());
        }
    }
}
