import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ssafy {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int N = inputCount();
        for (int i = 0; i < N; i++) {
            int count = inputTest();
            System.out.println("#" + (i + 1) + " " + count);
        }
    }

    private static int inputTest() {
        try {
            String[] s = br.readLine().split(" ");
            int memberCount = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            List<Integer> abilities = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return getLargestGroupSize(abilities, K);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getLargestGroupSize(List<Integer> abilities, int k) {
        Collections.sort(abilities);

        int maxGroupSize = 0;
        int start = 0;

        for (int i = 0; i < abilities.size(); i++) {
            if (start!=i&&abilities.get(i) - abilities.get(start) <= k)
                maxGroupSize = Math.max(maxGroupSize, i - start + 1);
            else
                start = i;
        }
        return maxGroupSize;
    }


    private static int inputCount() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
