import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main11651 {
    static class Position implements Comparator<Position> {
        private final int x;
        private final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Position o1, Position o2) {
            if (o1.y - o2.y != 0)
                return o1.y - o2.y;
            return o1.x - o2.x;
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }
    private static List<Position> positions=new ArrayList<>();
    public static void main(String[] args) {
        setPositions();
        positions.sort((o1, o2) -> {
            if (o1.y - o2.y != 0)
                return o1.y - o2.y;
            return o1.x - o2.x;
        });
        positions.forEach(System.out::println);
    }

    private static void setPositions() {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                positions.add(new Position(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
