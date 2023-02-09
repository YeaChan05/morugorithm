import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Main2751 {

    private static int N;
    private static List<Integer> inputs = new ArrayList<Integer>();
    public static void main(String[] args) {
        inputNumber();
        quikSort(inputs);
        inputs.forEach(System.out::println);
    }

    private static void quikSort(List<Integer> inputs) {
        quikSort(inputs,0,inputs.size()-1);
    }

    private static void quikSort(List<Integer> inputs, int start, int end) {
        if (start >= end) return;

        int mid = partition(inputs, start, end);
        quikSort(inputs, start, mid - 1);
        quikSort(inputs, mid, end);
    }


    private static int partition(List<Integer> inputs, int start, int end) {
        while(start<=end){
            int middle_val=inputs.get((start+end)/2);
            while(inputs.get(start)<middle_val){
                start++;
            }
            while (inputs.get(end)>middle_val){
                end--;
            }

            if (start <= end) {
                swap(inputs, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void inputNumber() {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        for (int i = 0; i < N; i++) {
            inputs.add(scanner.nextInt());
        }
    }
}
