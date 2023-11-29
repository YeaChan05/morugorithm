import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        List<String> book = new ArrayList<>();
        Map<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            book.add(bookName);
            bookMap.put(bookName, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isAlphabetic(question.charAt(0))) {
                sb.append(bookMap.get(question)).append("\n");
            } else {
                sb.append(book.get(Integer.parseInt(question) - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
