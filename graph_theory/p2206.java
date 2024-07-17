import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p2206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] arr = new int[n][m];
        int[][][] visited = new int[n][m][2];
        Deque<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        q.addLast(new int[] {0, 0, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] i = q.removeFirst();
            int x = i[0], y = i[1], flag = i[2];

            if (x == n - 1 && y == m - 1) {
                result = visited[x][y][flag];
                break;
            }

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny][flag] == 0) {
                    if (arr[nx][ny] == 1) {
                        if (flag == 0) {
                            q.addLast(new int[] {nx, ny, 1});
                            visited[nx][ny][1] = visited[x][y][flag] + 1;
                        }
                    } else {
                        q.addLast(new int[] {nx, ny, flag});
                        visited[nx][ny][flag] = visited[x][y][flag] + 1;
                    }
                }
            }
        }

        System.out.println(result);
    }
}