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
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        
        int n = fr.nextInt(); // 총 사람의 수
        ArrayList<Integer> times = new ArrayList<>();

        // 각 사람마다 처리 시간 입력받기
        for (int i = 0; i < n; i++) {
            int time = fr.nextInt();
            times.add(time);
        }

        Collections.sort(times); // 오름차순 정렬
        int result = 0;
        for (int i = 0; i < n; i++) { // 처리 시간을 하나씩 보면서
            // i번째 사람을 처리하면, 뒤쪽에는 n - i명이 기다리므로
            // 거기에 자기 자신을 처리하는 시간 더하기
            result += times.get(i) * (n - i - 1) + times.get(i);
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
