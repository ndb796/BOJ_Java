import java.util.*;
import java.io.*;

class Node {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();

        // (N X M) 크기의 배열 초기화
        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = fr.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 좌, 하, 상, 우
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};

        // BFS 수행
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            Node cur = queue.poll(); // 매번 큐에서 원소를 꺼내고
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) { // 꺼낸 원소와 인접한 원소들 방문
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 인접한 원소에 방문 불가능하다면 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == 0) continue;
                // 방문이 가능하다면
                visited[nx][ny] = true;
                graph[nx][ny] = graph[x][y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }
        System.out.println(graph[n - 1][m - 1]);
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

/*
import java.io.*;
import java.util.*;

class Node {

  private int x;
  private int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}

public class Main {

  public static int[][] visited = new int[100][100];
  public static int[][] arr = new int[100][100];
  public static int n, m;
  public static int[] dx = { 0, -1, 0, 1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    n = scanner.nextInt();
    m = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      String line = scanner.next();
      for (int j = 0; j < line.length(); j++) {
        int current = line.charAt(j) - '0';
        arr[i][j] = current;
      }
    }

    Queue<Node> q = new LinkedList<>();
    visited[0][0] = 1;
    q.offer(new Node(0, 0));

    while (!q.isEmpty()) {
      Node cur = q.poll();
      int x = cur.getX();
      int y = cur.getY();
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (arr[nx][ny] == 0)
          continue;
        if (visited[nx][ny] != 0)
          continue;
        visited[nx][ny] = visited[x][y] + 1;
        q.offer(new Node(nx, ny));
      }
    }
    System.out.println(visited[n - 1][m - 1]);
  }
}
*/
