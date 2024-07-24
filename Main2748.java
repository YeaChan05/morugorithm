import java.math.BigDecimal;
import java.util.Scanner;

public class Main2748 {
    private static BigDecimal[] arr = new BigDecimal[91];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr[0] = BigDecimal.valueOf(0);
        arr[1] = BigDecimal.valueOf(1);
        for (int i = 2; i <= 90; i++) {
            arr[i]=arr[i-1].add(arr[i-2]);
        }
        System.out.println(arr[n]);
    }

}
