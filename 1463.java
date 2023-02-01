import java.io.*;
import java.util.*;

public class Main {

  public static int[] dp = new int[1000001];
  public static int n;

  public static int solve(int x) {
    // 종료 조건(초기항)
    if (x == 1) return 0;
    // 이미 계산한 적 있는 값이라면
    if (dp[x] != 0) return dp[x];
    // 그렇지 않다면, 점화식 계산
    int result = (int) 1e9;
    if (x % 3 == 0) result = Math.min(result, solve(x / 3) + 1);
    if (x % 2 == 0) result = Math.min(result, solve(x / 2) + 1);
    result = Math.min(result, solve(x - 1) + 1);
    dp[x] = result; // 계산한 결과는 저장
    return result;
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    System.out.println(solve(n));
  }
}
