import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class p1991 {
    public static Node[] tree = new Node[26];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[data - 'A'] == null) {
                tree[data - 'A'] = new Node(data);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[data - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[data - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        sb.append("\n");

        System.out.print(sb);
    }

    public static void preorder(Node v) {
        if (v == null) {
            return;
        }
        sb.append(v.data);
        preorder(v.left);
        preorder(v.right);
    }

    public static void inorder(Node v) {
        if (v == null) {
            return;
        }
        inorder(v.left);
        sb.append(v.data);
        inorder(v.right);
    }

    public static void postorder(Node v) {
        if (v == null) {
            return;
        }
        postorder(v.left);
        postorder(v.right);
        sb.append(v.data);
    }
}
