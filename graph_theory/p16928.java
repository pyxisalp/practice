import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] jump = new int[101];
        int[] visited = new int[101];
        Deque<Integer> q = new LinkedList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jump[u] = v;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jump[u] = v;
        }

        visited[1] = 1;
        q.addLast(1);

        while (!q.isEmpty()) {
            int x = q.removeFirst();

            if (x == 100) {
                System.out.println(visited[100] - 1);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = x + i;
                if (nx > 100 || visited[nx] != 0) {
                    continue;
                }
                visited[nx] = visited[x] + 1;
                if (jump[nx] != 0) {
                    if (visited[jump[nx]] == 0) {
                        visited[jump[nx]] = visited[x] + 1;
                        q.addLast(jump[nx]);
                    }
                } else {
                    q.addLast(nx);
                }
            }
        }
    }
}
