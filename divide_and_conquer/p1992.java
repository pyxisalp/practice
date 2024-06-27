import java.io.*;

public class p1992 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        dnq(arr, 0, 0, n);
    }

    public static void dnq(int[][] arr, int x, int y, int k) {
        int mark = arr[x][y];
        int flag = 1;
        
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (mark != arr[i][j]) {
                    flag = 0;
                    break;
                }
            }
        }

        if (flag == 1) {
            if (mark == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        else {
            System.out.print("(");
            dnq(arr, x, y, k / 2);
            dnq(arr, x, y + k / 2, k / 2);
            dnq(arr, x + k / 2, y, k / 2);
            dnq(arr, x + k / 2, y + k / 2, k / 2);
            System.out.print(")");
        }
    }
}