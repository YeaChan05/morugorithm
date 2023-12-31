import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] isVisited;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            arr = initArray(N, M, K);
            isVisited = new boolean[N][M];
            
            int count=0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (isVisited[y][x] || arr[y][x] != 1)
                        continue;
                    dfs(y,x);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    
    private static void dfs(int y, int x) {
        isVisited[y][x] = true;
        int M= arr.length;
        int N=arr[0].length;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            
            if (cx < 0 || cy < 0 || cx >= N || cy >= M)//이동 위치가 배열 밖인 경우
                continue;
            if (isVisited[cy][cx] || arr[cy][cx] != 1)//방문한적 있거나 배추가 없는 경우
                continue;
            dfs(cy, cx);
        }
    }
    
    private static int[][] initArray(int N, int M, int K) throws IOException {
        int[][] arr = new int[N][M];
        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
        }
        return arr;
    }
    
}
