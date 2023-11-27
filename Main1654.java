import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1654 {
    private static int N;
    public static void main(String[] args) {
        List<Integer> lines = readLineSize();
        long max = lines.stream().mapToLong(Integer::longValue).max().getAsLong();

        long head = 1;
        long tail = max;
        long result = 0;

        while (head <= tail) {
            long mid = (head + tail) / 2;
            if (getAvailableLineCount(mid, lines) >= N) {
                result = mid;
                head = mid + 1;
            } else
                tail = mid - 1;
        }

        System.out.println(result);
    }

    private static Long getAvailableLineCount(long availableSize, List<Integer> lines) {
        return lines.stream()
                .mapToLong(eachSize -> eachSize / availableSize).sum();
    }

    private static List<Integer> readLineSize() {
        List<Integer> lines=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++)
                lines.add(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
