import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int n = fr.nextInt(); // 동전(화폐) 종류
        int k = fr.nextInt(); // 거슬러 줄 돈

        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) { // N개 만큼의 화폐 입력
            int x = fr.nextInt();
            coins.add(x);
        }
        int result = 0;
        for (int i = n - 1; i >= 0; i--) { // 큰 화폐부터 보기
            result += k / coins.get(i); // 해당 화폐로 몇 개 가능?
            k %= coins.get(i);
        }
        System.out.println(result);
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
