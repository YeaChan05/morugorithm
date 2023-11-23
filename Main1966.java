import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1966 {
    public static void main(String[] args) throws IOException {
        inputTest();
    }

    private static void inputTest() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                String[] s = br.readLine().split(" ");
                int N = Integer.parseInt(s[0]);
                int M = Integer.parseInt(s[1]);
                ArrayDeque<Integer> priority = new ArrayDeque<>(
                        Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
                whenToPrint(priority, M);
            }
        }
    }

    private static void whenToPrint(ArrayDeque<Integer> priority, int m) {
        List<Integer> printed = new ArrayList<>();
        do {
            Integer polled = priority.poll();
            if (priority.isEmpty()) {
                printed.add(polled);
                break;
            }
            m--;
            if (priority.stream().anyMatch(integer -> integer > polled)) {//우선순위가 높은 출력물 존재
                priority.addLast(polled);
                if(m==-1)
                    m = priority.size() - 1;
            } else {//출력 가능한 경우
                printed.add(polled);
                if(m==-1)//출력하는 내용이 원하는 내용일때
                    break;
            }
        } while (true);
        System.out.println(printed.stream().count());
    }
}
