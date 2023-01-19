import java.io.*;
import java.util.*;

public class Main {

  public static boolean[] visited = new boolean[11];
  public static Stack<Integer> result = new Stack<Integer>();
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static int n;
  public static int minValue = (int) 1e9;

  // 2부터 N까지의 수를 하나씩 골라 나열하는 모든 순열을 계산
  public static void dfs(int depth) {
    if (depth == n - 1) {
      // 현재 순열에 대한 처리
      int totalCost = 0;
      // 1번 노드에서 출발
      int cur = 1;
      // 현재 순열에 따라서 노드 이동
      for (int i = 0; i < n - 1; i++) {
        // 다음 이동 노드까지의 비용 계산
        int nextNode = result.get(i);
        int cost = graph.get(cur).get(nextNode);
        if (cost == 0) return; // 이동 불가능하면 무시
        // 이동 가능하면, 비용을 더하고 노드 이동
        totalCost += cost;
        cur = nextNode;
      }
      // 마지막 노드에서 1로 돌아오는 것이 필수
      int cost = graph.get(cur).get(1);
      if (cost == 0) return; // 이동 불가능하면 무시
      // 이동 가능하면, 비용을 더하고 노드 이동
      totalCost += cost;
      // 경로의 최소 비용 저장
      minValue = Math.min(minValue, totalCost);
      return;
    }
    for (int i = 2; i <= n; i++) {
      if (visited[i]) continue;
      // 방문 처리
      result.push(i);
      visited[i] = true;
      dfs(depth + 1); // 재귀 함수 호출
      // 방문 처리 해제
      result.pop();
      visited[i] = false;
    }
  }
  
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for (int i = 1; i <= n; i++) {
      graph.get(i).add(0);
      for (int j = 1; j <= n; j++) {
        int cost = scanner.nextInt();
        graph.get(i).add(cost);
      }
    }
    dfs(0);
    System.out.println(minValue);
  }
}
