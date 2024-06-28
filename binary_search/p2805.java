import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long low = 0, high = 0, result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while (low < high) {
            long temp = 0;
            long mid = (low + high) / 2;

            for (int i = 0; i < n; i++) {
                temp += Math.max(arr[i] - mid, 0);
            }
            if (temp < m) {
                high = mid;
            } else {
                low = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}