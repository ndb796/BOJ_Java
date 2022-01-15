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
        if (this.x != other.x) {
            return this.x - other.x;
        }
        else {
            return this.y - other.y;
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
        
        int n = fr.nextInt();

        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            arrayList.add(new Point(x, y));
        }

        Collections.sort(arrayList);
        for (int i = 0; i < n; i++) {
            System.out.println(arrayList.get(i));
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
