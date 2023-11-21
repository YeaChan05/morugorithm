import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main7568 {
    private static final List<Size> sizes=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        inputInfo();
        List<String> ranks = setRanks().stream().map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join(" ", ranks));
    }

    private static List<Integer> setRanks() {
        return sizes.stream()
                .map(size -> Math.toIntExact(sizes.stream()
                        .filter(size1 -> size1.compareTo(size) < 0)
                        .count()+1))
                .collect(Collectors.toList());
    }

    private static void inputInfo() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int weight = Integer.parseInt(s[0]);
                int height = Integer.parseInt(s[1]);
                sizes.add(new Size(weight,height));
            }
        }
    }

    private static class Size implements Comparable<Size> {
        private final Integer weight;
        private final Integer height;

        public Size(Integer weight, Integer height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Size o) {
            if (this.weight > o.weight && this.height > o.height) return -1;
            if (this.weight < o.weight && this.height < o.height) return 1;
            return 0;
        }
    }
}