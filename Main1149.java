import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> town = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] costs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            town.add(costs);
        }

        int[][] dp = new int[N][3];
        int[] costs = town.get(0);
        dp[0][0] = costs[0];
        dp[0][1] = costs[1];
        dp[0][2] = costs[2];

        int townSize = town.size();
        for (int i = 1; i < townSize; i++) {
            costs = town.get(i);
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[2];
        }
        int min = Arrays.stream(dp[townSize - 1]).min().getAsInt();
        System.out.println(min);
    }
}
