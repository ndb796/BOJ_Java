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
