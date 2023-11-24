import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main1541 {
    private static List<List<Integer>> numbers;
    public static void main(String[] args) {
        writeModification();

        List<Integer> sums = numbers.stream()
                .map(integers -> integers.stream().mapToInt(value -> value).sum())
                .collect(Collectors.toList());
        int total=sums.get(0);
        for (int i = 1; i < sums.size(); i++)
            total-=sums.get(i);

        System.out.println(total);
    }


    private static void writeModification() {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            numbers = Arrays.stream(line.split("-"))
                    .map(s -> Arrays.stream(s.split("\\+"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
