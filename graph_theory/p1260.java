import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1260 {
    public static int n, m, v;
    public static int[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph.get(i).add(j);
            graph.get(j).add(i);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[n + 1];
        dfs(v);
        sb.append("\n");

        visited = new int[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int i) {
        visited[i] = 1;
        sb.append(i).append(" ");

        for (int j: graph.get(i)) {
            if (visited[j] == 0) {
                dfs(j);
            }
        }
    }

    public static void bfs(int i) {
        Deque<Integer> q = new LinkedList<>();
        q.addLast(i);
        visited[i] = 1;
        sb.append(i).append(" ");

        while (!q.isEmpty()) {
            int j = q.removeFirst();

            for (int k: graph.get(j)) {
                if (visited[k] == 0) {
                    q.addLast(k);
                    visited[k] = 1;
                    sb.append(k).append(" ");
                }
            }
        }
    }
}
