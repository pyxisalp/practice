import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] set = new int[V + 1];
            int[] visited = new int[V + 1];
            Deque<Integer> q = new LinkedList<>();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int flag = 1;

            for (int i = 1; flag == 1 && i <= V; i++) {
                if (visited[i] == 1) {
                    continue;
                }

                q.addLast(i);
                visited[i] = 1;
                set[i] = 1;
                   
                while (!q.isEmpty() && flag == 1) {
                    int x = q.removeFirst();
    
                    for (int j: graph.get(x)) {
                        if (visited[j] == 0) {
                            q.addLast(j);
                            visited[j] = 1;
                            set[j] = (set[x] == 1) ? 0 : 1;
                        }
                        else {
                            if (set[x] == set[j]) {
                                flag = 0;
                                break;
                            }
                        }
                    }
                }
            }

            if (flag == 1) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}