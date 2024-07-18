import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p4195 {
    public static int[] parent;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();

            parent = new int[f * 2];
            cnt = new int[f * 2];
            for (int i = 0; i < f * 2; i++) {
                parent[i] = i;
                cnt[i] = 1;
            }

            while (f-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                union(map.get(a), map.get(b));
                sb.append(cnt[find(map.get(b))] + "\n");
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
            cnt[y] += cnt[x];
        }
    }
}
