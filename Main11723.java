import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            switch (line.split(" ")[0]){
                case "add": {
                    int x=Integer.parseInt(line.split(" ")[1]);
                    set.add(x);
                    break;
                }
                case "remove":{
                    int x=Integer.parseInt(line.split(" ")[1]);
                    set.remove(x);
                    break;
                }
                case "check":{
                    int x=Integer.parseInt(line.split(" ")[1]);
                    if(set.contains(x))
                        sb.append(1+"\n");
                    else
                        sb.append(0+"\n");
                    break;
                }
                case "toggle":{
                    int x=Integer.parseInt(line.split(" ")[1]);
                    if(!set.remove(x))
                        set.add(x);
                    break;
                }
                case "all":{
                    set=new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
                    break;
                }
                case "empty":{
                    set=new HashSet<>();
                    break;
                }
            }
        }
        br.close();
        System.out.println(sb);
    }
}
