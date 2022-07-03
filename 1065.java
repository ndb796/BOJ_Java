/*
[문제 설명]
X의 각 자릿수가 등차수열을 이룬다면, "한수"
1부터 N까지의 모든 "한수"를 출력하는 문제

[예시]
101 -> 한수 X
98 -> 한수 O
7 -> 한수 O
123 -> 한수 O
124 -> 한수 X

[풀이 방법]
* x가 100 미만이라면, 전부 한수
* x가 100 이상 1000 미만이라면, 등차수열인지 계산해봐야 앎
* x가 1000이라면, 한수 아님
*/

import java.util.*;
import java.io.*;

public class Main {
    public static boolean oneNumber(int x) {
        if (x < 100) return true; // 100 미만이면 한수 O
        else if (x >= 100 && x < 1000) { // 세자릿수
            int x_1 = x % 10; // 일의 자리
            int x_2 = (x / 10) % 10; // 십의 자리
            int x_3 = (x / 100); // 백의 자리
            // 등차수열이라면 한수 O, 아니라면 한수 X
            if (x_1 - x_2 == x_2 - x_3) return true;
            else return false;
        }
        else return false; // 1000인 경우 한수 X
    }
  
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int count = 0;
        // 1부터 N까지의 수 중에서 한수인 것의 개수를 출력
        for (int i = 1; i <= n; i++) {
            if (oneNumber(i)) count++;
        }
        System.out.println(count);
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
