import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main4153 {
    static int a;
    static int b;
    static int c;
    static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) throws IOException {
        List<String> answer = new ArrayList<String>();
        while (true) {
            input();
            if (a == 0 && b == 0 && c == 0) break;
            answer.add(calc());
        }

        answer.forEach(System.out::println);
    }


    private static String calc() {
        if ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
                || (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2))
                || (Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2)))
            return "right";

        return "wrong";
    }

    private static void input() throws IOException {
        String str = reader.readLine();
        String[] ele = str.split(" ");
        a = Integer.parseInt(ele[0]);
        b = Integer.parseInt(ele[1]);
        c = Integer.parseInt(ele[2]);
    }
}