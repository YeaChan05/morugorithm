import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1436 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        mkDoomNum(list);
        System.out.println(list.get(scanner.nextInt() - 1));
    }

    private static void mkDoomNum(List<Integer> list) {
        for (int i = 1; list.size()<=10000; i++) {
            if(String.valueOf(i).contains("666")) {
                list.add(i);
            }
        }
    }
}
