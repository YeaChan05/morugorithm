import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int priority = computePriority(n, r, c);
        System.out.println(priority);
    }
    
    private static int computePriority(int n, int y, int x) {
        int size = (int) Math.pow(2, n);
        boolean isOverHalfX = (size / 2) <= x;
        boolean isOverHalfY = (size / 2) <= y;
        int weight;
        if (!isOverHalfX && !isOverHalfY) {
            weight = 0;
        } else if (isOverHalfX && !isOverHalfY) {
            weight = 1;
            x -= size / 2;
        } else if (!isOverHalfX && isOverHalfY) {
            weight = 2;
            y -= size / 2;
        } else {
            weight = 3;
            x -= size / 2;
            y -= size / 2;
        }
        int startWeight = (int) (weight * Math.pow(4, n - 1));
        if (n == 1)
            return startWeight;
        return startWeight + computePriority(n - 1, y, x);
    }
}
