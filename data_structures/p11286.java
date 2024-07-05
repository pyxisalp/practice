import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    } else {
                        return Math.abs(o1) - Math.abs(o2);
                    }
                }
            }
        );

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                heap.add(x);
            } else {
                if (heap.size() > 0)
                    System.out.println(heap.poll());
                else
                    System.out.println(0);
            }
        }
    }
}
