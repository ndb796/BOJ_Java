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
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            dist.add(fr.nextInt());
        }
        ArrayList<Integer> cost = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            cost.add(fr.nextInt());
        }
  
        // 주유 비용(cost) 배열의 값이 내림차순이 되도록 반환
        // [5, 2, 4, 1] -> [5, 2, 2, 1]
        int minCost = cost.get(0);
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, cost.get(i));
            cost.set(i, minCost);
        }

        // 도로당 이동 비용의 합 계산
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += (long) dist.get(i) * cost.get(i);
        }
        System.out.println(answer);
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

거리: 2 3 1 2
주유 비용: 5 2 4 7 8


    거리:2      거리:3     거리:1         거리:2
[5원]     [2원]        [4원]       [7원]        [8원]

=> "뒤에 있는" 자기보다 비싼 주유소를 미리 "결제"한다.

[핵심] 비오름차순 처리하기

예시 1)
주유 비용: 5 2 4 7 8
실제 주유 비용: 5 2 2 2 2

예시 2)
거리: 2 3 1 2
주유 비용: 7 5 8 4 9
실제 주유 비용: 7 5 5 4 4

답: (7 * 2) + (5 * 3) + (5 * 1) + (4 * 2)
[아이디어 핵심] 비오름차순으로 바꾸어주기

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 전체 주유소의 수
    int n = scanner.nextInt();
    
    int[] distances = new int[n - 1];
    int[] costs = new int[n];

    // 전체 거리(distance) 입력받기
    for (int i = 0; i < n - 1; i++) {
      distances[i] = scanner.nextInt();
    }
    // 전체 비용(cost) 입력받기
    for (int i = 0; i < n; i++) {
      costs[i] = scanner.nextInt();
    }

    // 실제 비용은 비오름차순으로 재정의
    int[] realCosts = new int[n];
    int minValue = costs[0];
    for (int i = 0; i < n; i++) {
      if (minValue > costs[i]) minValue = costs[i];
      realCosts[i] = minValue;
    }

    // 실제 주유 비용 계산
    long result = 0;
    for (int i = 0; i < n - 1; i++) {
      result += (long) distances[i] * realCosts[i];
    }
    System.out.println(result);
  }
}

*/
