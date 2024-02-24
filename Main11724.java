import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main11724 {
    
    private static final Map<Integer, List<Integer>> map=new HashMap<>();
    private static final  List<Integer> visited=new ArrayList<>();
    private static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            map.put(i+1,new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        for (int i = 0; i < n; i++) {
            int size = visited.size();
            dfs(i+1);
            if(size!=visited.size())
                count++;
        }
        System.out.println(count);
    }
    
    private static void dfs(Integer point) {
        if(visited.contains(point))
            return;
        visited.add(point);
        List<Integer> list = map.get(point);
        list.stream()
                .forEach(integer -> dfs(integer));
    }
    
}
