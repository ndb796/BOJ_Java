import java.io.*;
import java.util.*;

public class Main {

  public static boolean[] visited = new boolean[10];
  public static Stack<Integer> result = new Stack<Integer>();
  public static ArrayList<Integer> arr = new ArrayList<Integer>();
  public static int n;
  public static int maxValue = (int) -1e9;

  public static void dfs(int depth) {
    // 각 순열에 대한 처리
    if (depth == n) {
      // 공식 계산
      int current = 0;
      for (int i = 0; i < n - 1; i++) {
        current += Math.abs(result.get(i) - result.get(i + 1));
      }
      if (maxValue < current) {
      }
      maxValue = Math.max(maxValue, current);
    }
    // 각 수를 N개 선택하는 모든 순열 계산
    for (int i = 0; i < n; i++) {
      // 미리 고른 수라면 무시하도록
      if (visited[i])
        continue;
      // 현재 선택한 수 방문 처리
      visited[i] = true;
      result.push(arr.get(i));
      dfs(depth + 1); // 재귀 함수 호출
      // 현재 선택한 수 방문 처리 취소
      visited[i] = false;
      result.pop();
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      arr.add(scanner.nextInt());
    }
    dfs(0);
    System.out.println(maxValue);
  }
}
