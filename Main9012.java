import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main9012 {
    private static List<String> strings=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        inputStrings();
        strings.forEach(Main9012::isVPS);
    }

    private static void inputStrings() throws IOException {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                strings.add(br.readLine());
            }
        }
    }

    private static void isVPS(String readLine) {
        int counter=0;
        for (char c:readLine.toCharArray()) {
            if(c=='(')
                counter++;
            if (c==')')
                counter--;
            if(counter<0)
                break;
        }
        if(counter == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
