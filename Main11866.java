import java.util.*;

public class Main11866 {
    private static int N;
    private static int K;
    private static final Queue<Integer> queue = new LinkedList<>();
    private static final List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        input();
        rmElement();
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if(i!=answer.size()-1)
                System.out.print(", ");
        }
        System.out.print(">");
    }

    private static void rmElement() {
        for (int cnt=1;!queue.isEmpty();cnt++) {
            Integer temp = queue.poll();
            if (cnt % K == 0) {
                answer.add(temp);
            } else {
                queue.add(temp);
            }
        }
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
    }

}

