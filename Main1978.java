import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count=0;
        for (int i = 0; i < N; i++) {
            int input=scanner.nextInt();
            if(isPrime(input))
                count++;
        }
        System.out.println(count);
    }

    private static boolean isPrime(int input) {
        List<Integer> list=new ArrayList<>();
        for(int i=1; i<=input;i++){
            if(input%i==0)
                list.add(i);
        }
        if(list.size()==2)
            return true;
        return false;
    }
}
