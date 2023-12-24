import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main9095 {
    private static List<Integer> dp=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        calcPatternType();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp.get(num));
        }
    }
    
    private static void calcPatternType() {
        initBuffer();
        for (int i = 4; i < 11; i++) {
            int sum = dp.get(i - 1) + dp.get(i - 2) + dp.get(i - 3);
            dp.add(sum);
        }
    }
    
    private static void initBuffer() {
        dp.add(0);
        dp.add(1);
        dp.add(2);
        dp.add(4);
    }
}
