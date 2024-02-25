import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> inputs= Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        List<Integer> sorted = inputs.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        
        int count=0;
        Map<Integer,Integer> table=new HashMap<>();
        for (Integer value : sorted) {
            if(!table.containsKey(value)){
                table.put(value, count);
                count++;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        inputs.stream()
                .map(table::get)
                .map(integer -> integer+" ")
                .collect(Collectors.toList())
                .forEach(sb::append);
        System.out.println(sb);
    }
}
