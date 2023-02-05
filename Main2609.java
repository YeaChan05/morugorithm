import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();

        int first=Integer.parseInt(input.split(" ")[0]);
        int second=Integer.parseInt(input.split(" ")[1]);

        List<Integer> firstPrimeNumber = new ArrayList<>();
        List<Integer> secondPrimeNumber = new ArrayList<>();

        factorization(first,firstPrimeNumber);
        factorization(second, secondPrimeNumber);

        int gfc=GFC(firstPrimeNumber,secondPrimeNumber);
        System.out.println(gfc);
        System.out.println((first*second)/gfc);
    }


    private static int GFC(List<Integer> firstPrimeNumber, List<Integer> secondPrimeNumber) {
        List<Integer> common = new ArrayList<>();
        for (Integer value : firstPrimeNumber) {
            for (Integer integer : secondPrimeNumber) {
                if (Objects.equals(value, integer)) {
                    common.add(value);
                    break;
                }
            }
        }
        return common.get(common.size()-1);
    }

    private static void factorization(int num, List<Integer> primeNumber) {
        for (int i = 1; i <=num ; i++)
            if(num % i == 0)
                primeNumber.add(i);
    }
}
