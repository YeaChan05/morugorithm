import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * package :  PACKAGE_NAME
 * fileName : Main1270
 * author :  ShinYeaChan
 * date : 2023-07-15
 */
public class Main1270 {

    public static void main(String[] args) throws IOException {
        input();
    }



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            List<String > list= new ArrayList<>(Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList()));
            Integer  Ti = Integer.parseInt(list.remove(0));
            Map<String,Integer> armies=new HashMap<String,Integer>();

            for (int j = 0; j < Ti; j++) {
                String input = list.get(j);
                int count=1;
                if(Objects.nonNull(armies.get(input)))
                    count=armies.get(input)+1;
                armies.put(input, count);
            }

            String name="SYJKGW";

            List<Map.Entry<String, Integer>> collect = armies.entrySet().stream()
                    .filter(stringIntegerEntry -> stringIntegerEntry.getValue() > (Ti / 2))
                    .collect(Collectors.toList());
            if(!collect.isEmpty())
                name= String.valueOf(collect.get(0).getKey());


            System.out.println(name);
        }


    }
}
