import java.util.*;
import java.io.*;

public class Main {
   
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int n = fr.nextInt(); // 나무의 개수
        int m = fr.nextInt(); // 가져갈 최소 나무 크기

        // n개의 나무 길이에 대해서 입력
        int maxLength = (int) -1e9;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            maxLength = Math.max(maxLength, arr[i]);
        }

        int start = 0; // 탐색 범위 시작점
        int end = maxLength; // 탐색 범위 끝점
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2; // 중간점(높이)
            long total = 0;
            // 나무를 하나씩 확인하면서, mid로 자른 뒤에 나무 얻기
            for (int i = 0; i < n; i++) {
                if (mid < arr[i]) total += arr[i] - mid;
            }
            if (total < m) { // 더 많이 자르기
                end = mid - 1;
            } 
            else { // 덜 자르기
                start = mid + 1;
                result = mid;
            }
        }
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

/*

전체 나무의 개수: 5개
필요한 나무 높이: 20

4 42 40 26 46

[1단계]
left: 4, right: 46
이때, mid (height): (4 + 46) / 2 = 25
즉, 25로 잘랐을 때 얻는 나무의 총 높이는
17 + 15 + 1 + 21 = 54
따라서, 충분히 얻었으므로, 높이를 더 높여야 됨.

[2단계]
left: 26, right: 46
이때, mid (height): (26 + 46) / 2 = 36
즉, 36으로 잘랐을 때 얻는 나무의 총 높이는
6 + 4 + 10 = 20
따라서, 충분히 얻었으므로, 높이를 더 높여야 됨.

[3단계]
left: 37, right: 46
...

"가장 마지막으로 조건을 만족하는 높이 값"을 출력.

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    // 전체 나무의 개수 입력받기
    int n = scanner.nextInt();
    // 필요한 나무의 높이 입력받기
    int m = scanner.nextInt();

    // 각 나무의 높이 입력받기
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    // 이진 탐색 수행
    int left = 0;
    int right = 1000000000;
    int result = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      // 현재 높이로 자르기 수행
      long total = 0;
      for (int i = 0; i < n; i++) {
        if (mid < arr[i]) total += arr[i] - mid;
      }
      // 충분히 얻었다면 높이를 더 높여보기
      if (total >= m) {
        left = mid + 1;
        result = mid;
      }
      else { // 그렇지 않다면, 높이를 낮추어보기
        right = mid - 1;
      }
    }
    System.out.println(result);
  }
}

*/
