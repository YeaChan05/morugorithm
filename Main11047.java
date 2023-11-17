import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main11047 {
    private static int N;
    private static int K;
    private static List<Integer> valueTypes=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        setField();
        valueTypes.sort((o1, o2) -> o2-o1);
        int count=0;
        for (int i = 0; i < valueTypes.size(); i++) {
            if(K/ valueTypes.get(i)==0)
                continue;
            count+=K/ valueTypes.get(i);
            K=K% valueTypes.get(i);
        }
        System.out.println(count);
    }

    private static void setField() throws IOException {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            K = Integer.parseInt(s[1]);
            for (int i = 0; i < N; i++) {
                valueTypes.add(Integer.parseInt(br.readLine()));
            }
        }
    }

}
