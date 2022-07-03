import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = 9;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            arrayList.add(x);
        }
        /*
        // 푸는 방법 1
        int maxValue = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            int x = arrayList.get(i);
            if (x > maxValue) {
                maxValue = x;
                maxIndex = i;
            }
        }
        */
        int maxValue = Collections.max(arrayList);
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            int x = arrayList.get(i);
            if (x == maxValue) {
                maxIndex = i;
                break;
            }
        }
        System.out.println(maxValue + "\n" + (maxIndex + 1));
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
