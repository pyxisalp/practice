import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList();
        int n = Integer.parseInt(br.readLine());
        int length = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
                length++;
            } else if (cmd.equals("pop")) {
                if (length > 0) {
                    sb.append(q.poll()).append("\n");
                    length--;
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(length).append("\n");
            } else if (cmd.equals("empty")) {
                if (length == 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("front")) {
                if (length > 0) {
                    sb.append(q.getFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else {
                if (length > 0) {
                    sb.append(q.getLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
