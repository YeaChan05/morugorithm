import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2475 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        input(list);
        System.out.println(calc(list));
    }

    public static void input(List<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            if (value > 0 && value < 10) list.add(value);
        }
    }

    private static int calc(List<Integer> list) {
        int temp=0;
        for (int ele:list) {
            temp+=Math.pow(ele,2);
        }
        return temp%10;
    }
}