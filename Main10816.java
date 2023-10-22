import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> cards = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        int m = Integer.parseInt(br.readLine());
        countSameCards(br.readLine(), cards);
    }

    private static void countSameCards(String s, List<String> cards) {
        Map<String, Long> cardCounts = new HashMap<>();
        for (String card : cards)
            cardCounts.put(card, cardCounts.getOrDefault(card, 0L) + 1);


        List<String> list = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            message.append(cardCounts.getOrDefault(temp, 0L));
            if (i != list.size() - 1) {
                message.append(" ");
            }
        }

        System.out.println(message);
    }
}
