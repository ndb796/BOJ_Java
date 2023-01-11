import java.util.*;
import java.io.*;

/*
  * B에서 A로 이동한다고 가정한다.
  1) B가 2로 나누어떨어지면, 2로 나누는 것만 가능하다.
  2) B의 일의 자릿수가 1이면, 10으로 나누는 것만 가능하다.
  3) 둘 다 아니라면 이동이 불가능하므로, 종료한다.
*/

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int a = fr.nextInt();
        int b = fr.nextInt();

        int result = 1;
        boolean flag = false;
        while (a <= b) {
          if (a == b) {
            flag = true;
            break;
          }
          if (b % 2 == 0) b /= 2;
          else if (b % 10 == 1) b /= 10;
          else break;
          result++;
        }
        if (flag) System.out.println(result);
        else System.out.println(-1);
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
