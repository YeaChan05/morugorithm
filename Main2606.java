import java.util.*;

public class Main2606 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computerCount = scanner.nextInt();
        int adjacencyCount = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computerCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < adjacencyCount; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        System.out.println(countInfectedComputers(computerCount, graph));
    }

    public static int countInfectedComputers(int computerCount, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[computerCount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : graph.get(current))
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
        }

        return count;
    }
}
