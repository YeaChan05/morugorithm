import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int num = calc(i);
            if (num == n) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    static int calc(int n) {
        int temp = n;
        while (n != 0) {
            temp += n % 10;
            n /= 10;
        }
        return temp;
    }
}
