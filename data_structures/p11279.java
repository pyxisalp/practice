import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
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