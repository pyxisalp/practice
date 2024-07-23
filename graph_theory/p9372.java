import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p9372 {
    public static int n, cnt, result;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            cnt = 0;
            result = 0;
            visited = new boolean[n + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            dfs(1);

            sb.append(result + "\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        cnt++;

        if (cnt == n) {
            return;
        }

        for (int i: graph.get(start)) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
    }
}
