import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1085 {
    private static int x, y;
    private static int w, h;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        listInit();
        System.out.println(list.stream().min(Integer::compare).get());
    }

    private static void listInit() {
        list.add(x);
        list.add(y);
        list.add(w-x);
        list.add(h-y);
    }


    private static void input() {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        w = scanner.nextInt();
        h = scanner.nextInt();
    }
}