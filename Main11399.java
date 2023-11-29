import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < N; i++) {
            int time = numbers.get(i);
            map.put(i,time);
        }

        List<Integer> times = map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() - o2.getValue() == 0)
                return o1.getKey() - o2.getKey();
            return o1.getValue() - o2.getValue();
        }).map(Map.Entry::getValue).collect(Collectors.toList());

        int sum=0;
        int size = times.size();
        for (int i = 0; i < size; i++) {
            sum+=times.get(i)*(size-i);
        }
        System.out.println(sum);


    }
}
