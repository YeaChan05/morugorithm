import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String [] arr={"A","B","C","D"};
        List<String[]> permBySwap = permBySwap(arr,0,arr.length,arr.length);
        List<String[]> permByBacktracking = permByBacktracking(arr,new String[arr.length], 0);
        for (String[] permutation : permByBacktracking) {
            System.out.println(Arrays.toString(permutation));
        }
    }
    
    private static List<String[]> permBySwap(String[] arr, int depth, int n, int r) {
        List<String[]> permutations = new ArrayList<>();
        if (depth == r) {
            permutations.add(arr.clone());
            return permutations;
        }
        
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);//스왑
            permutations.addAll(permBySwap(arr, depth + 1, n, r));
            swap(arr, i, depth);// 다시 원상복귀
        }
        return permutations;
    }
    
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    
    private static List<String[]> permByBacktracking(String[] arr, String[] output, int depth) {
        List<String[]> permutations = new ArrayList<>();
        if (depth == arr.length) {
            permutations.add(output.clone());
            return permutations;
        }
        
        for (String string : arr) {
            if (Arrays.asList(output).subList(0, depth).contains(string))
                continue;
            output[depth] = string;
            permutations.addAll(permByBacktracking(arr, output.clone(), depth + 1));
        }
        return permutations;
    }
}