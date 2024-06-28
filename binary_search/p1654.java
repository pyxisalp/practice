import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long high = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }
        long low = 0;
        long result = 0;
        high++;
        
        while (low < high) {
            long temp = 0;
            long mid = (low + high) / 2;

            for (int i = 0; i < k; i++)
                temp += arr[i] / mid;
            if (temp < n)
                high = mid;
            else {
                result = mid;
                low = mid + 1;
            }
        }
        
        System.out.println(result);
    }
}
