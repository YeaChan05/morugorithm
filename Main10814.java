import java.util.*;

public class Main10814 {
    private static List<String> inputs = new ArrayList<>();
    
    public static void main(String[] args) {
        input();
        Collections.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[0])-Integer.parseInt(o2.split(" ")[0]);
            }
        });
        inputs.forEach(System.out::println);
    }




    private static void input() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            inputs.add(i,scanner.nextLine());
        }
    }
}
