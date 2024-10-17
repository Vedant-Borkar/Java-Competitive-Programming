import java.io.*;

public class Div170A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            String a = br.readLine().trim();
            String b = br.readLine().trim();

            pw.println(calc(a, b));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    private static int calc(String a, String b) {
        int preLen = commonLen(a, b);

        if (preLen == 0) {
            return a.length() + b.length();
        } else {
            return preLen + 1 + (a.length() - preLen) + (b.length() - preLen);
        }
    }

    private static int commonLen(String a, String b) {
        int len = 0;
        int minLen = Math.min(a.length(), b.length());

        while (len < minLen && a.charAt(len) == b.charAt(len)) {
            len++;
        }

        return len;
    }
}
