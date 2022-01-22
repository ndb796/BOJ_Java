import java.util.*;
import java.io.*;

public class Main {

    public static int result = 0;
    public static boolean[] visited = new boolean[101];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int x) {
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) {
                visited[y] = true;
                dfs(y);
                result++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(); // 노드의 개수
        for (int i = 0; i <= n; i++) { // 각 노드와 연결된 인접 노드를 담기
            graph.add(new ArrayList<Integer>()); // 0번 노드부터 n번 노드까지
        }
        int m = fr.nextInt(); // 간선의 개수
        for (int i = 0; i < m; i++) { // (x, y) => x와 y가 서로 연결
            int x = fr.nextInt();
            int y = fr.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        visited[1] = true;
        dfs(1);
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
