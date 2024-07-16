import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] arr = new int[n][m];
        Deque<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    q.addLast(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point curr = q.removeFirst();

            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[curr.x][curr.y] + 1;
                        q.addLast(new Point(nx, ny));
                    }
                }
            }
        }

        int max = -1, flag = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    flag = 0;
                    break;
                }
                max = Math.max(max, arr[i][j]);
            }
            if (flag == 0) {
                break;
            }
        }

        if (flag == 0) {
            System.out.println(-1);
        } else if (max == -1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }
}
