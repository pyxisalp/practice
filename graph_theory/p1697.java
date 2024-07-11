import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        Deque<Point> q = new LinkedList<>();

        q.addLast(new Point(n, 0));
        visited[n] = 1;

        while (!q.isEmpty()) {
            Point curr = q.removeFirst();
            int[] next = {curr.x * 2, curr.x + 1, curr.x - 1};

            if (curr.x == k) {
                System.out.println(curr.y);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (0 <= next[i] && next[i] <= 100000) {
                    if (visited[next[i]] == 0) {
                        q.addLast(new Point(next[i], curr.y + 1));
                        visited[next[i]] = 1;
                    }
                }
            }
        }
    }
}