import java.io.*;
import java.util.*;

public class Main {

  public static boolean[] visited = new boolean[10];
  public static Stack<Integer> result = new Stack<Integer>();
  public static ArrayList<String> arr = new ArrayList<String>();
  public static int k;
  public static String current;
  public static String first = "";

  public static void dfs(int depth) {
    // 각 순열에 대한 처리
    if (depth == k + 1) {
      // 부등식을 만족하는지 확인
      boolean check = true;
      for (int i = 0; i < k; i++) {
        if (arr.get(i).equals("<")) {
          if (result.get(i) > result.get(i + 1))
            check = false;
        } else if (arr.get(i).equals(">")) {
          if (result.get(i) < result.get(i + 1))
            check = false;
        }
      }
      // 부등식을 만족하는 경우에
      if (check) {
        current = "";
        for (int x : result) {
          current += x + "";
        }
        // 첫째 문자열은 "가장 작은 수"
        if (first.equals(""))
          first = current;
      }
      return;
    }
    // 0부터 9까지의 숫자를 하나씩 고르는 순열(백트래킹)
    for (int i = 0; i < 10; i++) {
      // 미리 고른 숫자라면 무시하도록
      if (visited[i])
        continue;
      // 현재 선택한 숫자 방문 처리
      visited[i] = true;
      result.push(i);
      dfs(depth + 1); // 재귀 함수 호출
      // 현재 선택한 숫자 방문 처리 취소
      visited[i] = false;
      result.pop();
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    k = scanner.nextInt();
    for (int i = 0; i < k; i++) {
      arr.add(scanner.next());
    }
    dfs(0);
    // 마지막에 남은 current 값은 "가장 큰 문자열"
    System.out.println(current + "\n" + first);
  }
}
