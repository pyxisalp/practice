import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1197 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int result = 0;
        parent = new int[v + 1];
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[] {a, b, c});
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int[] o: edges) {
            if (find(o[0]) == find(o[1])) {
                continue;
            }
            union(o[0], o[1]);
            result += o[2];
        }

        System.out.println(result);
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
