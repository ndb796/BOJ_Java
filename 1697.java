import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int k = fr.nextInt();

        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // System.out.println(cur);
            if (cur + 1 <= 100000) {
                if (!visited[cur + 1]) {
                    dist[cur + 1] = dist[cur] + 1;
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }
            }
            if (cur - 1 >= 0) {
                if (!visited[cur - 1]) {
                    dist[cur - 1] = dist[cur] + 1;
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }
            }
            if (cur * 2 <= 100000) {
                if (!visited[cur * 2]) {
                    dist[cur * 2] = dist[cur] + 1;
                    queue.offer(cur * 2);
                    visited[cur * 2] = true;
                }
            }
        }
        System.out.println(dist[k]);
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
