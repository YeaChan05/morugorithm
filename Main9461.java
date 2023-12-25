import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main9461 {
    private static List<Long> dp = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        dp.add(1L);
        dp.add(1L);
        dp.add(1L);
        dp.add(2L);
        
        for (int i = 4; i < 100; i++)
            dp.add(dp.get(i - 2) + dp.get(i - 3));
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp.get(n-1));
        }
    }
}
