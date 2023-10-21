import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main10845 {
    private static List<Integer> queue= new ArrayList<>();
    public static void main(String[] args) throws IOException {
        inputCommand();
    }

    private static void inputCommand() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            String message = br.readLine();
            commandOf(message);
        }
    }
    public static void commandOf(String message){
        if(message.equals("pop")) {
            System.out.println(queue.isEmpty()?-1:queue.remove(0));
        } else if(message.equals("size")) {
            System.out.println(queue.size());
        } else if(message.equals("empty")) {
            System.out.println(queue.isEmpty() ? 1 : 0);
        } else if(message.equals("front")) {
            System.out.println(!queue.isEmpty() ? queue.get(0) : -1);
        } else if(message.equals("back")) {
            System.out.println(!queue.isEmpty() ? queue.get(queue.size()-1) : -1);
        } else if(message.split(" ")[0].equals("push")) {
            queue.add(Integer.parseInt(message.split(" ")[1]));
        }
    }
}
