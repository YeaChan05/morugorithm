import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1931 {
    public static void main(String[] args) throws IOException {
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int startTime = Integer.parseInt(s[0]);
                int endTime = Integer.parseInt(s[1]);
                reservations.add(new Reservation(startTime, endTime));
            }
        }
        reservations.sort((r1, r2) -> {
            if (r1.getEndTime() == r2.getEndTime()) {
                return Integer.compare(r1.getStartTime(), r2.getStartTime());
            }
            return Integer.compare(r1.getEndTime(), r2.getEndTime());
        });

        int count = 0;
        int end = 0;
        for (Reservation reservation : reservations) {
            if (reservation.getStartTime() >= end) {
                end = reservation.getEndTime();
                count++;
            }
        }

        System.out.println(count);
    }
}
class Reservation {
    private final int startTime;
    private final int endTime;

    public Reservation(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
