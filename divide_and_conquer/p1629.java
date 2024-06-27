import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(dnq(a, b, c));
    }

    public static long dnq(int x, int y, int z) {
        if (y == 1) {
            return x % z;
        }
        if (y % 2 == 0) {
            long temp = dnq(x, y / 2, z);
            return temp * temp % z;
        } else {
            long temp = dnq(x, y / 2, z);
            return (temp * temp % z) * x % z;
        }
    }
}
