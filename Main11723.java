import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int bitmask = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            String command = line[0];
            int x = 0;

            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(line[1]);
            }

            switch (command) {
                case "add":
                    bitmask |= (1 << (x - 1));
                    break;
                case "remove":
                    bitmask &= ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append(((bitmask & (1 << (x - 1))) != 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << (x - 1));
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
