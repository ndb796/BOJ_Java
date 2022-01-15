import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);
  
        int testCases = fr.nextInt();
        for (int tc = 0; tc < testCases; tc++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            buffWriter.write((a + b) + "\n");
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
