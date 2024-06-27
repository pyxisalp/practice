import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int max = -100 * k;

        for (int i = 0; i < n; i++)
            arr[i + 1] =  arr[i] + Integer.parseInt(st.nextToken());
        
        for (int i = k; i <= n; i++)
            max = Math.max(max, arr[i] - arr[i - k]);
        
        System.out.println(max);
    }
}