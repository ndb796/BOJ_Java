import java.util.*;
import java.io.*;

/*
- 다른 모든 지원자와 비교했을 때 (1) 서류 성적과 (2) 면접 성적 중 적어도 하나가, 다른 지원자보다 떨어지지 않는 사람의 수를 세는 문제다.
(3, 6)
(7, 3)
(4, 2)
(1, 4)
(5, 7)
(2, 5)
(6, 1)
- X를 기준으로 오름차순 정렬
- 위에서부터 한 명씩 보면서, minY보다 순위가 높다면 카운트
(1, 4) count: 1, minY: 4
(2, 5) minY: 4
(3, 6) minY: 4
(4, 2) count: 2, minY: 2
(5, 7) minY: 2
(6, 1) count: 3, minY: 1
(7, 3) minY: 1
*/

class Point implements Comparable<Point> {
    public int x;
    public int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point other) {
        return this.x - other.x;
    }
}

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCase = fr.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            int n = fr.nextInt();
            ArrayList<Point> arr = new ArrayList<Point>();
            for (int i = 0; i < n; i++) {
                int x = fr.nextInt();
                int y = fr.nextInt();
                arr.add(new Point(x, y));
            }
            Collections.sort(arr);
            int cnt = 0;
            int minY = 100001;
            for (Point point : arr) {
                if (point.y < minY) {
                  minY = point.y;
                  cnt++;
                }
            }
            System.out.println(cnt);
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
