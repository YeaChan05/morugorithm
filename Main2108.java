import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main2108 {

    private static int total=0;
    public static void main(String[] args) {
        List<Integer> values=inputValues();
        values.sort(Comparator.comparingInt(Integer::intValue));
        int size = values.size();
        int mod = getMod(values);
        System.out.println(Math.round((float) total / size));
        System.out.println(values.get((size-1)/2));
        System.out.println(mod);
        System.out.println(values.get(size-1)-values.get(0));
    }

    private static int getMod(List<Integer> values) {
        Map<Integer,Integer> map=new HashMap<>();

        for (Integer value : values)
            map.merge(value, 1, Integer::sum);

        Integer maxCount = map.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();

        List<Map.Entry<Integer, Integer>> maxList = map.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue()==maxCount)
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .collect(Collectors.toList());

        if(maxList.size()==1)
            return maxList.get(0).getKey();
        else
            return maxList.get(1).getKey();
    }


    private static List<Integer> inputValues() {
        List<Integer> values=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                int value = Integer.parseInt(br.readLine());
                values.add(value);
                total+=value;
            }
            return values;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}