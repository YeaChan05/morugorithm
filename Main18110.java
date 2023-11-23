import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main18110 {
    public static void main(String[] args) throws IOException {
        List<Integer> difficulty=inputDifficulty();
        int cutSize = (int)Math.round(difficulty.size() * 0.15);
        difficulty.sort(Comparator.comparingInt(Integer::intValue));
        double total = 0.0;
        for (int j = cutSize; j < difficulty.size()-cutSize; j++)
            total += difficulty.get(j);
        System.out.println((int) Math.round(total/ (difficulty.size()-2*cutSize)));
    }

    private static List<Integer> inputDifficulty() throws IOException {
        List<Integer> difficulty=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                int dif = Integer.parseInt(br.readLine());
                difficulty.add(dif);
            }
        }
        return difficulty;
    }
}
