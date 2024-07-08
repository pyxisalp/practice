import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1520 {
    public static int m, n;
    public static int[][] arr, dp;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];      
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1)
            return 1;
        if (dp[x][y] != -1)
            return dp[x][y];
        
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                if (arr[nx][ny] < arr[x][y])
                    dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}