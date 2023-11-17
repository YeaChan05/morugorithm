import java.util.*;

public class Main1920 {

    public static void main(String[] args) {
        try(Scanner scanner=new Scanner(System.in)) {
            List<Integer> compareGroup=setList(scanner);
            List<Integer> list =setList(scanner);
            compareGroup.sort(Integer::compareTo);
            compareEach(list,compareGroup);
        }
    }

    private static void compareEach(List<Integer> list, List<Integer> compareGroup) {
        for (Integer element : list) {
            System.out.println(brSearch(compareGroup, element) >= 0 ? 1 : 0);
        }
    }

    private static int brSearch(List<Integer> array, Integer element) {
        int head=0;
        int tail=array.size()-1;
        while (head<=tail){
            int middle=(head+tail)/2;
            if(array.get(middle)>element)
                tail=middle-1;
            else if(array.get(middle)<element)
                head=middle+1;
            else return middle;
        }
        return -1;
    }


    private static List<Integer> setList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        int bound = scanner.nextInt();
        for (int i = 0; i < bound; i++) {
            Integer nextInt = scanner.nextInt();
            list.add(nextInt);
        }
        return list;
    }
}
