import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int flag = 1;
        for (int i = 1; i < m; i++) {
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (find(x) != find(y)) {
                flag = 0;
                break;
            }
            x = y;
        }

        System.out.println((flag == 1) ? "YES" : "NO");
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } 
        parent[a] = find(parent[a]);
        return find(parent[a]);
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[x] = y;
        }
    }
}
