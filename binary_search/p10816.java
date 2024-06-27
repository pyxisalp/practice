import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(a);

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.print((ub(a, target) - lb(a, target)) + " ");
        }
        System.out.println();
    }

    public static int lb(int[] a, int target) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= a[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static int ub(int[] a, int target) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (target < a[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}