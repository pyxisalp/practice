import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.awt.Point;

public class p2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] arr = new int[n][m];
        int[][] visited = new int[n][m];
        Deque<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        q.addLast(new Point(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Point curr = q.removeFirst();

            if (curr.x == n - 1 && curr.y == m - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] != 0 && visited[nx][ny] == 0) {
                        q.addLast(new Point(nx, ny));
                        visited[nx][ny] = 1;
                        arr[nx][ny] = arr[curr.x][curr.y] + 1;
                    }
                }
            }
        }

        System.out.println(arr[n - 1][m - 1]);
    }
}
