import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main11727 {
    public static void main(String[] args) throws IOException {
        int n = readInteger();
        List<Integer>dp=new ArrayList<>();
        dp.add(1);
        dp.add(1);
        
        for (int i = 2; i <=n; i++){
            int num = dp.get(i - 1) + dp.get(i - 2)*2;
            dp.add(num%10007);
        }
        System.out.println(dp.get(n));
    }
    
    
    private static int readInteger() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
