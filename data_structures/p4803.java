import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p4803 {
    public static int n, m, t = 0, cnt;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            t++;
            cnt = 0;
            visited = new boolean[n + 1];
            graph = new ArrayList<>();

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
                if (!visited[i]) {
                    if (dfs(i, 0)) {
                        cnt++;
                    }
                }
            }

            if (cnt > 1) {
                sb.append("Case " + t + ": A forest of " + cnt + " trees.\n");
            } else if (cnt == 1) {
                sb.append("Case " + t + ": There is one tree.\n");
            } else {
                sb.append("Case " + t + ": No trees.\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean dfs(int curr, int prev) {
        visited[curr] = true;

        for (int i: graph.get(curr)) {
            if (i == prev) {
                continue;
            }
            if (visited[i]) {
                return false;
            }
            if (!dfs(i, curr)) {
                return false;
            }
        }

        return true;
    }
}
