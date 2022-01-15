import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int[] cnt = new int[10001];

        int n = fr.nextInt();
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            cnt[x]++;
        }

        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);
  
        for (int i = 0; i <= 10000; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                buffWriter.write(i + "\n");
            }
        }
        // Flush the buffer writer
        buffWriter.flush();
        System.out.println(stringWriter.getBuffer());
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
