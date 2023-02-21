import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2751 {

    private static int N;
    private static List<Integer> inputs = new ArrayList<Integer>();
    public static void main(String[] args) {
        inputNumber();
        Collections.sort(inputs);
        outputNumber();
    }

    private static void outputNumber() {
        StringBuilder stringBuilder =new StringBuilder();
        for (Integer i:inputs) {
            stringBuilder.append(i).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void inputNumber() {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        for (int i = 0; i < N; i++) {
            inputs.add(scanner.nextInt());
        }
    }
}
