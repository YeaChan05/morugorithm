import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        mkList();
        System.out.println(answer());
    }

    private static void mkList() {
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            list.add(i,scanner.nextInt());
        }
    }

    private static String answer() {
        int ascending = 0;
        int descending = 0;
        for (int el : list) {
            if (list.get(el - 1) == el) ascending++;
            if (list.get(el - 1) == 9 - el) descending++;
        }
        if (ascending == 8) return "ascending";
        if (descending == 8) return "descending";

        return "mixed";
    }
}
