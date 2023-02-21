import java.util.*;

public class Main10814 {
    private static List<List<String>> data=new ArrayList<>();
    public static void main(String[] args) {
        input();
        System.out.println(data);

    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String temp=scanner.nextLine();
            String age=temp.split(" ")[0];
            String name=temp.split(" ")[1];
            System.out.println(age+ " "+name);
//            int age=Integer.parseInt(temp.split(" ")[0]);
//            String name=temp.split(" ")[1];
//            System.out.println("age: "+age);
//            System.out.println("name: "+name);
//            data.get(age).add(name);
        }
    }
}
