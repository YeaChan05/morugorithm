import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Map<String,String >map=new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            map.put(strings[0],strings[1]);
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            bw.append(map.get(br.readLine())).append("\n");
        }
        bw.flush();
    }
}