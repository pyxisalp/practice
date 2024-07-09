import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int length = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("1")) {
                s.push(Integer.parseInt(st.nextToken()));
                length++;
            } else if (cmd.equals("2")) {
                if (length > 0) {
                    sb.append(s.pop()).append("\n");
                    length--;
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (cmd.equals("3")) {
                sb.append(length).append("\n");
            } else if (cmd.equals("4")) {
                if (length == 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                if (length > 0) {
                    sb.append(s.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
