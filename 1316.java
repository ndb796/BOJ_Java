/*
"그룹 단어"란, 단어에 존재하는 모든 문자에 대해서,
각 문자가 연속해서 나타나는 경우만을 말한다.

aaaaabbbbbccccc: 그룹 단어 O
aaaaabbbbbccccca: 그룹 단어 X
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int result = 0;
        for (int testCase = 0; testCase < n; testCase++) {
            String s = fr.next();
            boolean groupWord = true;
            // 이미 처리된 문자를 담기 위한 집합(Set) 자료형
            HashSet<Character> hashSet = new HashSet<Character>();
            hashSet.add(s.charAt(0));
            // 하나씩 문자를 확인하며
            for (int i = 1; i < s.length(); i++) {
                // 이미 처리된 문자라면
                if (hashSet.contains(s.charAt(i))) {
                    // 바로 앞에 있는 문자랑 같지 않다면(그룹이 아니라면)
                    if (s.charAt(i) != s.charAt(i - 1)) {
                        groupWord = false;
                    }
                }
                else hashSet.add(s.charAt(i));
            }
          if (groupWord) result++;
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
