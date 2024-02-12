import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int blueCount = 0;
    private static int whiteCount = 0;
//    private static boolean[][] isClear;
    
    
    public static void main(String[] args) throws IOException {
        Integer n = writeSize();
        int[][] arr = initArr(n);
//        isClear = new boolean[n][n];
        //TODO 2/12/24 / 5 42 pm : 잘라야할지 체크
        /*
         * 처음에는 (0,0)을 n사이즈 만큼
         * 다음에는 (0,0),(n/2,0), (0,n/2), (n/2, n/2)을 n/2사이즈 만큼
         * 그 다음에는 16개의 점을 n/4사이즈 만큼...
         * k번째에는 4^(k-1)개의 점을 n/2^(k-1)사이즈 만큼 탐색한다
         * */
        //1. 기준점과 다른게 있으면 다음 스텝, 없으면 isClear true처리 후 기준점에 금지영역으로 지정, 해당 영역의 갯수를 확인 후 blueCount 혹은 whiteCount를 더함
        //2. 다음스텝으로 넘어가게되면 새로운 기준점 부여(단, 금지영역은 제외)
        bfs(arr,0,0);
        
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }
    
    private static void bfs(int[][] arr,int y, int x) {
        int n = arr.length;
        int refVal = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (refVal!= arr[i][j]) {//기준 깃발과 다른색이면
                    //4개로 쪼개서 bfs
                    bfs(copyArrToRange(arr, 0, 0, n / 2),0, 0);
                    bfs(copyArrToRange(arr, 0, n / 2, n / 2),0, n / 2);
                    bfs(copyArrToRange(arr, n / 2, 0, n / 2),n / 2, 0);
                    bfs(copyArrToRange(arr, n / 2, n / 2, n / 2),n / 2, n / 2);
                    return;
                }
            }
        }

        if (refVal == 0) whiteCount++;
        else blueCount++;
    }
    
    private static void setCount(int refVal) {
        if (refVal == 0) whiteCount++;
        else blueCount++;
    }
    
    private static int[][] copyArrToRange(int[][] arr, int y, int x, int size) {
        int[][] temp = new int[size][size];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                temp[i - y][j - x] = arr[i][j];
            }
        }
        return temp;
    }
    
    
    private static int[][] initArr(Integer n) throws IOException {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }
    
    private static Integer writeSize() throws IOException {
        st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}
