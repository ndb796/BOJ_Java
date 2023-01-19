import java.io.*;
import java.util.*;

public class Main {

  public static boolean[] visited = new boolean[10];
  public static Stack<Integer> result = new Stack<Integer>();
  public static int[][] arr = new int[10][2];
  public static int n;
  public static int answer = (int) 1e9;

  // N개의 재료 중에서 depth를 선택한 조합 계산
  public static void dfs(int depth, int start) {
    // "모든 개수"를 고려해야 하므로, depth가 1 이상이면 항상 처리
    // 현재 조합에 대한 처리
    if (depth >= 1) {
      int totalX = 1;
      int totalY = 0;
      for (int i: result) {
        int x = arr[i][0];
        int y = arr[i][01];
        totalX *= x;
        totalY += y;
      }
      answer = Math.min(answer, Math.abs(totalX - totalY));
    }
    for (int i = start; i < n; i++) {
      if (visited[i]) continue;
      // 방문 처리
      result.push(i);
      visited[i] = true;
      dfs(depth + 1, i + 1); // 재귀 함수 호출
      // 방문 처리 해제
      result.pop();
      visited[i] = false;
    }
  }
  
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      arr[i][0] = x;
      arr[i][1] = y;
    }
    dfs(0, 0);
    System.out.println(answer);
  }
}
