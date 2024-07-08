import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Huffman coding과 결과가 같을까?: No
 */

public class p11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++)
                arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());
            
            for (int diff = 1; diff < K; diff++) {
                for (int i = 1; i + diff <= K; i++) {
                    int j = i + diff;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[j] - arr[i - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}
