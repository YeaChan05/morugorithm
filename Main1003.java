import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            List<Integer> zeroCount=new ArrayList<>();
            List<Integer> oneCount=new ArrayList<>();

            zeroCount.add(0,1);
            zeroCount.add(1,0);

            oneCount.add(0,0);
            oneCount.add(1,1);
            for (int j = 2; j <=num; j++) {
                zeroCount.add(j, zeroCount.get(j-1)+ zeroCount.get(j-2));
                oneCount.add(j, oneCount.get(j-1)+ oneCount.get(j-2));
            }
            bw.append(String.valueOf(zeroCount.get(num))).append(" ").append(String.valueOf(oneCount.get(num))).append("\n");
        }
        bw.flush();
    }

}
