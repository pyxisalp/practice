import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class p1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x1, x2) -> x1[1] == x2[1] ? x1[0] - x2[0] : x1[1] - x2[1]);

        int f = arr[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= f) {
                f = arr[i][1];
                count += 1;
            }
        }
        
        System.out.println(count);
    }
}
