import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1107 {
    private static final boolean[] brokenButton=new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                brokenButton[num] = true;
            }
        }
        int result = getResult(n);
        
        System.out.println(result);
    }
    
    private static int getResult(final int n) {
        int result = Math.abs(n - 100);
        for (int i = 0; i <= 1000000; i++) {
            String str = String.valueOf(i);
            boolean isBroken = false;
            
            for (int j = 0; j < str.length(); j++) {
                if (brokenButton[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            
            if (!isBroken) {
                int pressCount = str.length() + Math.abs(i - n);
                result = Math.min(result, pressCount);
            }
        }
        return result;
    }
}