import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int size = 0;
        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("1")) {
                deque.offerFirst(Integer.parseInt(st.nextToken()));
                size++;
            } else if (cmd.equals("2")) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
                size++;
            } else if (cmd.equals("3")) {
                if (size > 0) {
                    sb.append(deque.removeFirst()).append("\n");
                    size--;
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (cmd.equals("4")) {
                if (size > 0) {
                    sb.append(deque.removeLast()).append("\n");
                    size--;
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (cmd.equals("5")) {
                sb.append(size).append("\n");
            } else if (cmd.equals("6")) {
                if (size == 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("7")) {
                if (size > 0) {
                    sb.append(deque.getFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else {
                if (size > 0) {
                    sb.append(deque.getLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
