import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class p2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[i] = Integer.parseInt(br.readLine());
        Arrays.sort(pos);
        int low = 1;
        int high = pos[n - 1] - pos[0] + 1;
        int result = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            int idx = 0;
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (pos[i] - pos[idx] >= mid) {
                    idx = i;
                    count++;
                }
            }

            if (count < c) {
                high = mid;
            } else {
                low = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}