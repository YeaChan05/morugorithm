import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2747 {
    private static List<Integer> nums=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        nums.addAll(List.of(0,1));
        for (int i = 2; i <=input ; i++) {
            int cur = nums.get(i - 2) + nums.get(i - 1);
            nums.add(cur);
        }
        System.out.println(nums.get(input));
    }
}
