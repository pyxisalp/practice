import java.io.*;
import java.util.*;

public class p1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < s1.length; i++) {
            int temp = 0;
            String[] s2 = s1[i].split("\\+");

            for (int j = 0; j < s2.length; j++)
                temp += Integer.parseInt(s2[j]);
            
            if (i == 0)
                result += temp;
            else
                result -= temp;
        }

        System.out.println(result);
    }
}