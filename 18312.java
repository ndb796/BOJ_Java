import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int h = fr.nextInt();
        int t = fr.nextInt();
        int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (i % 10 == t || // 시(hour)의 일의 자릿수가 K인 경우
                        i / 10 == t || // 시(hour)의 십의 자릿수가 K인 경우
                        j % 10 == t || // 분(minute)의 일의 자릿수가 K인 경우
                        j / 10 == t || // 분(minute)의 십의 자릿수가 K인 경우
                        k % 10 == t || // 초(second)의 일의 자릿수가 K인 경우
                        k / 10 == t) // 초(second)의 십의 자릿수가 K인 경우
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
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
