import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt(); // 데이터 개수
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(fr.nextInt());
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        ArrayList<Integer> unique = new ArrayList<>(set);
        Collections.sort(unique);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < unique.size(); i++) {
            map.put(unique.get(i), i);
        }

        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);
        for (int x : arr) buffWriter.write(map.get(x) + " ");
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
