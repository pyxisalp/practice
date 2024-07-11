import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            int[][] visited = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Point src = new Point(x, y);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Point dst = new Point(x, y);
            Deque<Point> q = new LinkedList<>();

            q.addLast(src);
            visited[src.x][src.y] = 1;

            while (!q.isEmpty()) {
                Point curr = q.removeFirst();

                if (curr.x == dst.x && curr.y == dst.y) {
                    sb.append(visited[dst.x][dst.y] - 1).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (0 <= nx && nx < l && 0 <= ny && ny < l) {
                        if (visited[nx][ny] == 0) {
                            q.addLast(new Point(nx, ny));
                            visited[nx][ny] = visited[curr.x][curr.y] + 1;
                        }
                    }
                }
            }
        }

        System.out.print(sb);
    }
}