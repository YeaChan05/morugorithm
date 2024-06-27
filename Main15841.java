import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15841 {
    private static List<BigDecimal> nums = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums.addAll(List.of(BigDecimal.ZERO, BigDecimal.ONE));
        for (int i = 2; i <= 490; i++) {
            BigDecimal cur = nums.get(i - 2).add(nums.get(i - 1));
            nums.add(cur);
        }
        int num = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if (num == -1)
                return;
            System.out.println("Hour " + num + ": " + nums.get(num) + " cow(s) affected");
        }
    }
}
