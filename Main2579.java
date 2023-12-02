import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
    private static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        stairs = new int[count];
        for (int i = 0; i < count; i++)
            stairs[i] = Integer.parseInt(br.readLine());
        System.out.println(maxScore());
    }

    private static int maxScore() {
        int n = stairs.length;
        if (n == 1)
            return stairs[0];

        int[] steps = new int[n];
        steps[0] = stairs[0];
        steps[1] = stairs[0] + stairs[1];
        if (n > 2)
            steps[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < n; i++)
            steps[i] = Math.max(steps[i-2] + stairs[i], steps[i-3] + stairs[i-1] + stairs[i]);

        return steps[n - 1];
    }
}
