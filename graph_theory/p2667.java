import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p2667 {
    public static int n, mark = 0, count = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] arr = new int[n][n];
    public static int[][] visited = new int[n][n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0 && visited[i][j] == 0) {
                    count = 0;
                    mark++;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        System.out.println(mark);
        for (int i: result) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        arr[x][y] = mark;
        visited[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (arr[nx][ny] != 0 && visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
