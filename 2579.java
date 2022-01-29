import java.util.*;
import java.io.*;

public class Main {

    public static int dp[][] = new int[300][2];
    public static int arr[] = new int[300];

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }

        // d[i][0]: 1개만 연속으로 밟은 경우
        // d[i][1]: 이미 2개 연속으로 밟은 경우
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        dp[1][0] = arr[1];
        dp[1][1] = arr[0] + arr[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i];
        }
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
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
