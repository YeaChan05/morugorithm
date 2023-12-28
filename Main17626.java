import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main17626 {
    
    public static void main(String[] args) throws IOException {
        int n = readInteger();
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i - (j * j)]);
            dp[i]++;
        }
        System.out.println(dp[n]);
    }
    
    
    private static int readInteger() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
