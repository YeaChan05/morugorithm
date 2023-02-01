import java.util.Scanner;
public class Main {
    private static int length;
    private static String message;
    static long r=1;
    final static int M=1234567891;

    public static void main(String[] args) {
        input();
        System.out.println(calc());
    }

    private static long calc() {
        long hash=0;
        for (int i = 0; i < length; i++) {
            hash += ((message.charAt(i)-'a'+1)*r)%M;
            r = (r*31)%M;
        }
        return hash%M;
    }

    private static void input() {
        Scanner scanner=new Scanner(System.in);
        length =scanner.nextInt();
        message =scanner.next();
    }
}
