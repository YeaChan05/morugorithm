import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Set<String> notListened=new HashSet<>();

        List<String> result=new ArrayList<>();
        for (int i = 0; i < N; i++)
            notListened.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if(notListened.contains(line))
                result.add(line);
        }
        System.out.println(result.size());
        result.sort(String::compareTo);
        result.forEach(System.out::println);
    }
}
