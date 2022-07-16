import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point other) {
        if (this.y != other.y) {
            return this.y - other.y;
        }
        else {
            return this.x - other.x;
        }
    }
    
    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            dist.add(fr.nextInt());
        }
        ArrayList<Integer> cost = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            cost.add(fr.nextInt());
        }
  
        // 주유 비용(cost) 배열의 값이 내림차순이 되도록 반환
        // [5, 2, 4, 1] -> [5, 2, 2, 1]
        int minCost = cost.get(0);
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, cost.get(i));
            cost.set(i, minCost);
        }

        // 도로당 이동 비용의 합 계산
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += (long) dist.get(i) * cost.get(i);
        }
        System.out.println(answer);
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
