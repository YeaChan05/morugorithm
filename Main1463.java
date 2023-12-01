import java.util.Scanner;

public class Main1463 {
    private static int operatorCounts[];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        operatorCounts = new int[num+1];

        operatorCounts[0] = 0;
        operatorCounts[1] = 0;

        for (int i = 2; i <= num; i++) {
            operatorCounts[i] = operatorCounts[i - 1] + 1;
            if (i % 2 == 0)
                operatorCounts[i] = Math.min(operatorCounts[i], operatorCounts[i / 2] + 1);
            if (i % 3 == 0)
                operatorCounts[i] = Math.min(operatorCounts[i], operatorCounts[i / 3] + 1);
        }
        System.out.println(operatorCounts[num]);
    }

}
