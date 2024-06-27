import java.io.*;
import java.util.*;

public class p2630 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[2];
        dnq(arr, 0, 0, n, result);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static void dnq(int[][] arr, int x, int y, int k, int[] result) {
        int color = arr[x][y];
        int flag = 1;
        
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (color != arr[i][j]) {
                    flag = 0;
                    break;
                }
            }
        }

        if (flag == 1) {
            if (color == 0) {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        else {
            dnq(arr, x, y, k / 2, result);
            dnq(arr, x + k / 2, y, k / 2, result);
            dnq(arr, x, y + k / 2, k / 2, result);
            dnq(arr, x + k / 2, y + k / 2, k / 2, result);
        }
    }
}