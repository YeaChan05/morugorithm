import java.util.*;

public class Main2798 {
    static int N;
    static int M;
    static List<Integer> list = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        Collections.sort(list);
        combination();
        calc();
    }

    private static void combination() {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = list.get(i) + list.get(j) + list.get(k);
                    if ((temp < sum) && (sum <= M))
                        temp = sum;
                }
            }

        System.out.println(temp);
    }

    private static void calc() {

    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
    }
}
