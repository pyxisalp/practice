import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11444 {
    public static long n;
    public static long[][] a = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long[][] result = dnq(n);
        System.out.println(result[1][0]);
    }

    public static long[][] dnq(long x) {
        if (x == 1L)
            return a;
        long[][] temp = dnq(x / 2);
        long[][] temp2 = mul(temp, temp);
        if (x % 2 == 0)
            return temp2;
        return mul(temp2, a);
    }

    public static long[][] mul(long[][] x, long[][] y) {
        long[][] z = new long[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    z[i][j] += x[i][k] * y[k][j];
                z[i][j] %= 1000000007;
            }
        }

        return z;
    }
}
