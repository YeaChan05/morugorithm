import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();

        int first=Integer.parseInt(input.split(" ")[0]);
        int second=Integer.parseInt(input.split(" ")[1]);


        int gfc=GFC(first,second);
        System.out.println(gfc);
        System.out.println((first*second)/gfc);
    }


    private static int GFC(int first, int second) {
        int temp= Math.min(first, second);
        for (int i = temp; i > 0; i--) {
            if((first%i==0)&&(second%i==0)) {
                return i;
            }
        }
        return 1;
    }


}
