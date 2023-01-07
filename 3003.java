import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader(); // 문제 해결 소스 코드
        
        int king = fr.nextInt();
        int queen = fr.nextInt();
        int rook = fr.nextInt();
        int bishop = fr.nextInt();
        int knight = fr.nextInt();
        int pawn = fr.nextInt();
        System.out.print((1 - king) + " ");
        System.out.print((1 - queen) + " ");
        System.out.print((2 - rook) + " ");
        System.out.print((2 - bishop) + " ");
        System.out.print((2 - knight) + " ");
        System.out.print((8 - pawn) + " ");
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
