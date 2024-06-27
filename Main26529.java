import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main26529 {
    private static List<BigInteger> nums = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        nums.addAll(List.of(BigInteger.ZERO, BigInteger.ONE));
        for (int i = 2; i <= 46; i++) {
            BigInteger num = nums.get(i - 1).add(nums.get(i - 2));
            nums.add(num);
        }
        
        for (int i = 0; i < count; i++) {
            int index = Integer.parseInt(br.readLine());
            System.out.println(nums.get(index+1));
        }
    }
}
