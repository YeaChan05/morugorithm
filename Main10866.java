import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main10866 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<String> deque=new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            command();
        }
    }

    private static void command() throws IOException {
        String[] commandLine = br.readLine().split(" ");
        switch (commandLine[0]){
            case "push_front":{
                deque.add(0,commandLine[1]);
                break;
            }
            case "push_back":{
                deque.add(deque.size(), commandLine[1]);
                break;
            }
            case "pop_front":{
                if (!deque.isEmpty()){
                    System.out.println(deque.remove(0));
                    break;
                }
                System.out.println("-1");
                break;
            }
            case "pop_back":{
                if (!deque.isEmpty()){
                    System.out.println(deque.remove(deque.size()-1));
                    break;
                }
                System.out.println("-1");
                break;
            }
            case "size":{
                System.out.println(deque.size());
                break;
            }
            case "empty":{
                System.out.println(deque.isEmpty()?1:0);
                break;
            }
            case "front":{
                if (!deque.isEmpty()){
                    System.out.println(deque.get(0));
                    break;
                }
                System.out.println("-1");
                break;
            }
            case "back":{
                if (!deque.isEmpty()){
                    System.out.println(deque.get(deque.size()-1));
                    break;
                }
                System.out.println("-1");
                break;
            }

        }
    }

}
