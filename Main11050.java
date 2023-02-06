import java.io.IOException;
import java.util.Scanner;

public class Main11050 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        System.out.println(binomialCoefficient(num1,num2));
    }

    private static int binomialCoefficient(int n, int k) {
        if(k<=n&&0<=k){
            return factorial(n)/(factorial(k)*factorial(n-k));
        }else return 0;
    }

    private static int factorial(int i) {
        int temp=1;
        for(int j=1;j<=i;j++){
            temp*=j;
        }
        return temp;
    }
}
