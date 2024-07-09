import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int order = 1;
        int[] visited = new int[n + 1];
        int[] result = new int[n + 1];
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        deque.addLast(r);
        visited[r] = 1;
        result[r] = order;
        order++;

        while (deque.size() != 0) {
            int x = deque.removeFirst();

            for (int i: graph.get(x)) {
                if (visited[i] == 0) {
                    deque.addLast(i);
                    visited[i] = 1;
                    result[i] = order;
                    order++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}
