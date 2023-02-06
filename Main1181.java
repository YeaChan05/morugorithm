import java.util.*;
import java.util.stream.Collectors;

public class Main1181 {
    private static Map<Integer,String> map= new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N=scanner.nextInt();
        List<String> words=new ArrayList<>();

        for (int i = 0; i <N; i++) {
            words.add(scanner.next());
        }
        words.sort(Comparator.naturalOrder());
        words.sort(Comparator.comparingInt(String::length));

        List<String> newList= words.stream().distinct().collect(Collectors.toList());
        newList.forEach(System.out::println);
    }
}
