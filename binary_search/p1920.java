import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(a);

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n - 1;
            int flag = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (target == a[mid]) {
                    flag = 1;
                    break;
                }
                else if (target < a[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            System.out.println((flag == 1) ? 1 : 0);
        }
    }
}