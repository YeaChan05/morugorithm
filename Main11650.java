import java.util.*;

public class Main11650 {
    private static List<List<Integer>> pos = new ArrayList<>();

    public static void main(String[] args) {
        input();
        Collections.sort(pos, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1)-o2.get(1);
            }
        });
        Collections.sort(pos, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });

        output();
    }

    private static void output() {
        for (int i = 0; i < pos.size(); i++) {
            System.out.println(pos.get(i).get(0)+" "+pos.get(i).get(1));
        }
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            pos.add(List.of(scanner.nextInt(),scanner.nextInt()));
        }
    }
}
