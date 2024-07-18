import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1717 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                sb.append((find(a) == find(b)) ? "YES" : "NO").append("\n");
            }
        }
    
        System.out.print(sb);
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