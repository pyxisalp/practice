import java.util.Scanner;

public class p2439 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++)
                System.out.print(" ");
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
