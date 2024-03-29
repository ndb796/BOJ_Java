import java.util.*;
import java.io.*;

public class Main {

    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        // n개의 데이터가 들어갈 배열
        int n = fr.nextInt();
        int[] arr = new int[n];

        // n개의 데이터 입력받기
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        Arrays.sort(arr); // 오름차순 정렬

        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);
  
        // m개의 쿼리 처리
        int m = fr.nextInt();
        for (int i = 0; i < m; i++) {
            int x = fr.nextInt();
            int result = countByRange(arr, x, x);
            buffWriter.write(result + " ");
        }

        // Flush the buffer writer
        buffWriter.flush();
        System.out.println(stringWriter.getBuffer());
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

N = 10 (원소의 수)
각 원소: 6 3 2 10 10 10 -10 -10 7 3
M = 8 (쿼리의 수)
찾을 원소: 10 9 -5 2 3 4 5 -10

O(MlogN): 각 쿼리에 대하여 log 시간 복잡도로 탐색을 수행

import java.io.*;
import java.util.*;

public class Main {

    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }
  
	public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    // 전체 원소 입력받기
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    // 이진 탐색을 위한 오름차순 정렬
    Arrays.sort(arr);
        
    StringWriter stringWriter = new StringWriter();
    BufferedWriter buffWriter = new BufferedWriter(stringWriter);
        
    // 전체 쿼리 입력받기
    int m = scanner.nextInt();
    String answer = "";
    for(int i = 0; i < m; i++) {
      int query = scanner.nextInt();
      int count = countByRange(arr, query, query);
      buffWriter.write(count + " ");
    }
    buffWriter.flush();
    System.out.println(stringWriter.getBuffer());
  }
}

*/
