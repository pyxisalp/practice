import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5639 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root = null;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            insert(Integer.parseInt(s));
        }
        
        postorder(root);

        System.out.print(sb);
    }

    public static void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node prev = null, curr = root;

            while (curr != null) {
                prev = curr;
                if (data < curr.data) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            if (data < prev.data) {
                prev.left = new Node(data);
            } else {
                prev.right = new Node(data);
            }
        }
    }

    public static void postorder(Node v) {
        if (v == null) {
            return;
        }

        postorder(v.left);
        postorder(v.right);
        sb.append(v.data + "\n");
    }
}
