import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1926 {
    private static int n=0;
    private static int m=0;
    private static int max=0;
    private static int pictureCount=0;
    private static List<List<Dot>> pallet=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 그림 정보 입력: 0 과 1을 공백 기준으로 입력받기
        makePallet();
        // 연결되어있는 1들을 기준으로 그림 찾기
        findPictures();
        //출력: 그림의 갯수, 가장 넓은 그림의 넓이
        System.out.println(pictureCount);
        System.out.println(max);
    }

    private static void findPictures() {
        for (int i = 0; i <n ;i++) {;
            for (int j = 0; j <m; j++) {
                Dot dot =pallet.get(i).get(j);
                if (dot.number!=1||dot.visited)
                    continue;
                int area = BFS(dot);
                max=Math.max(max,area);
                pictureCount++;
            }
        }
    }

    private static int BFS(Dot startDot) {
        Queue<Dot> queue = new LinkedList<>();
        int area = 0;

        queue.add(startDot);
        while (!queue.isEmpty()) {
            Dot currentDot = queue.poll();
            area++;
            pallet.get(startDot.y).get(startDot.x).visited=true;
            for (Direction direction : Direction.values()) {
                int newX = currentDot.x + direction.x;
                int newY = currentDot.y + direction.y;
                if(!isValidPos(newX, newY))
                    continue;
                Dot newDot = pallet.get(newY).get(newX);
                if(newDot.number == 1 && !newDot.visited){
                    newDot.visited = true;
                    queue.add(newDot);
                }
            }
        }

        return area;
    }

    private static boolean isValidPos(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }



    private static void makePallet() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);
        int i=0;
        while(i<n){
            String paint = br.readLine();
            List<Dot> dots=new ArrayList<>();
            List<Integer> line = Arrays.stream(paint.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 0; j < line.size(); j++) {
                Dot dot = Dot.of(j, i);
                dot.number= line.get(j);
                dots.add(dot);
            }
            pallet.add(dots);
            i++;
        }
    }

    enum Direction{
        NORTH(0,-1),
        EAST(1,0),
        WEST(-1,0),
        SOUTH(0,1);
        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Dot  {
        private int x;
        private int y;
        private int number;
        private boolean visited=false;

        private Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public static Dot of(int x, int y){
            return new Dot(x,y);
        }
    }
}