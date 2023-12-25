import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, String> map = createFashionMap(n, br);
            Set<String> valueSet = new HashSet<>(map.values());
            Map<String,Integer> countMap=new HashMap<>();
            for (String value : valueSet) {
                Integer count = (int) map.entrySet().stream().filter(entry -> entry.getValue().equals(value)).count();
                countMap.put(value,count);
            }
            List<Integer> collect = countMap.values().stream().map(value -> value + 1).collect(Collectors.toList());
            int mult=1;
            for (Integer integer : collect)
                mult *= integer;
            System.out.println(mult-1);
        }
    }
    
    private static Map<String, String> createFashionMap(int n, BufferedReader br) throws IOException {
        Map<String,String> map=new HashMap<>();
        for (int j = 0; j < n; j++) {
            String[] s = br.readLine().split(" ");
            String key=s[0];
            String value = s[1];
            map.put(key,value);
        }
        return map;
    }
}
