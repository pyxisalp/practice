import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        long[] rest = new long[m];
        long count = 0;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = (arr[i] + Integer.parseInt(st.nextToken())) % m;
            if (arr[i + 1] % m == 0)
                count++;
            rest[(int)arr[i + 1]]++;
        }

        for (int i = 0; i < m; i++)
            count += rest[i] * (rest[i] - 1) / 2;

        System.out.println(count);
    }
}