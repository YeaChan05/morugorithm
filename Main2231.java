import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2231 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int M=scanner.nextInt();

        for (int i =M; i >0; i--) {
            int sum=i;
            int temp=i;
            while(temp>0){
                sum+=temp%10;
                temp/=10;
            }
            if(M==sum)
                list.add(i);
        }
        if(list.isEmpty())
            list.add(0);
        System.out.println(Collections.min(list));
    }
}
