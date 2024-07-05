import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];
        int result = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        temp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp[result - 1]) {
                temp[result] = arr[i];
                result++;
                continue;
            }

            int low = 0;
            int high = result;

            while (low < high) {
                int mid = (low + high) / 2;

                if (arr[i] > temp[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            temp[low] = arr[i];
        }

        System.out.println(result);
    }

}
