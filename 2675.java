import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int r = fr.nextInt(); // 반복 횟수 r
            String s = fr.next(); // 문자열 s
            String result = "";
            // 문자열 s에 포함된 각 문자를 하나씩 확인하며
            for (int i = 0; i < s.length(); i++) {
                // 해당 문자를 r번만큼 반복하기
                char x = s.charAt(i);
                for (int j = 0; j < r; j++) {
                    result += Character.toString(x);
                }
            }
            System.out.println(result);
        }
    }
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
