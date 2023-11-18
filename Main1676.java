import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main1676 {
    public static void main(String[] args) {
        int N=input();
        BigInteger factorial= BigInteger.valueOf(1);
        for (int i = 1; i <=N; i++) {
            factorial=factorial.multiply(BigInteger.valueOf(i));
        }
        int countZero=countZero(factorial.toString().toCharArray());
        System.out.println(countZero);
    }

    private static int countZero(char[] charArray) {
        int count=0;
        int length = charArray.length;
        for (int i = length - 1; i >= 0; i--) {
           if(charArray[i]=='0')
               count++;
           else break;
        }
        return count;
    }

    private static int input() {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
