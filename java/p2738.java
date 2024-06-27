import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int i, j;

        for (i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++)
                arr[i][j] += Integer.parseInt(st.nextToken());
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            if (i != m - 1)
                System.out.println();
        }
    }
}