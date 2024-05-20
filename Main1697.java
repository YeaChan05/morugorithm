import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1697 {
    static final int MAX = 100000;
    static int[] visited = new int[MAX + 1];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        
        if (n == k) {
            System.out.println(0);
            return;
        }
        int result = bfs(n, k);
        System.out.println(result);
    }
    
    private static int bfs(final int start, final int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next == target) {
                    return visited[current];
                }
                
                if (next >= 0 && next <= MAX && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
        
        return -1;
    }
}