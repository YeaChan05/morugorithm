import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main11659 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> ordi=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        int next = Integer.parseInt(st.nextToken());
        ordi.add(next);
        list.add(next);
        for (int i = 1; i < N; i++) {
            Integer temp = list.get(i - 1);
            int nextInt = Integer.parseInt(st.nextToken());
            ordi.add(nextInt);
            list.add(temp+ nextInt);
        }
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken())-1;
            int tail = Integer.parseInt(st.nextToken())-1;
            
            System.out.println(list.get(tail)- list.get(head)+ordi.get(head));
        }
    }
    
    
}
