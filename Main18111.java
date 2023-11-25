import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main18111 {
    static class Position{
        private final int x;
        private final int y;
        private int height;

        public Position(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", height=" + height +
                    '}';
        }
    }
    private static int inventory;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<Position> positions=new ArrayList<>();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        inventory = Integer.parseInt(s[2]);
        for (int i = 0; i < N; i++) {
            List<String> s1 = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
            for (int j = 0; j < s1.size(); j++) {
                Position position = new Position(i, j,Integer.parseInt(s1.get(j)));
                positions.add(position);
            }
        }

        int totalBlockCount = inventory + positions.stream().mapToInt(Position::getHeight).sum();
        int maxHeight = totalBlockCount / positions.size();
        int minHeight = positions.stream()
                .map(Position::getHeight)
                .min(Comparator.comparingInt(Integer::intValue))
                .get();

        Map<Integer,Integer> timeSet=new HashMap<>();
        for (int i = minHeight; i <=maxHeight; i++) {
            int second=flatteningUpTo(i,positions);
            timeSet.put(i,second);
        }

        Integer minSecond = timeSet.values().stream()
                .min(Comparator.comparingInt(Integer::intValue))
                .get();
        List<Map.Entry<Integer, Integer>> minList = timeSet.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue().equals(minSecond)).collect(Collectors.toList());

        System.out.println(minSecond+" "+minList.get(minList.size()-1).getKey());
    }

    private static int flatteningUpTo(int height, List<Position> positions) {
        int second=0;
        for (Position pos:positions) {
            int remainingCount = height - pos.getHeight();
            if (remainingCount>0)
                second += Math.abs(remainingCount);
            else
                second += Math.abs(remainingCount) * 2;
        }
        return second;
    }

}
