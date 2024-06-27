import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }
        int[][] result = dnq(a, b, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] dnq(int[][] x, long y, int n) {
        if (y == 1L) {
            return x;
        }

        int[][] temp = dnq(x, y / 2, n);
        int[][] temp2 = mul(temp, temp, n);
        if (y % 2 == 0)
            return temp2;
        return mul(temp2, x, n);
    }

    public static int[][] mul(int[][] x, int[][] y, int n) {
        int[][] z = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++)
                    z[i][j] += x[i][k] * y[k][j];
                z[i][j] %= 1000;
            }
        }

        return z;
    }
}