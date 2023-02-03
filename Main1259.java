import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1259 {
    static int num;
    static List<String > list = new ArrayList<>();
    static List<String> answer=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        validation();
        answer.forEach(System.out::println);
    }

    private static void validation() {
        for(int i=0;i<list.size();i++){
            answer.add("yes");
            for (int j=0;j<list.get(i).length()/2;j++){
                if(list.get(i).charAt(j)
                        !=list.get(i).charAt(list.get(i).length()-1-j)){
                    answer.remove(i);
                    answer.add("no");
                    break;
                }
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String value=br.readLine();
            if(value.equals("0"))
                return;
            list.add(value);
        }
    }


}
