import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
            List<Integer> primeNumber = getPrimeNumber(M, N);
            primeNumber.forEach(System.out::println);
        }
    }

    private static List<Integer> getPrimeNumber(int m, int n) {
        List<Integer> primeNumber=new ArrayList<>();
        List<Boolean> isPrime =setPrime(n);
        for(int i=1; i<=n;i++)
            if (!isPrime.get(i) && i >= m)
                primeNumber.add(i);
        return primeNumber;
    }

    private static List<Boolean> setPrime(int n) {
        List<Boolean> isPrime=new ArrayList<>();
        for (int i = 0; i <= n; i++)
            isPrime.add(false);

        isPrime.set(0,true);
        isPrime.set(1,true);
        for(int i = 2; i*i<= n; i++){
            if(!isPrime.get(i))//방문하지 않은 숫자 확인
                for (int j = i * i; j <= n; j += i)//i의 배수들 전부 방문처리
                    isPrime.set(j, true);
        }
        return isPrime;
    }

}
