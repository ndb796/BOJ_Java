import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        String s = fr.next();
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char x = Character.toLowerCase(s.charAt(i));
            int index = x - 'a'; // 인덱스 계산
            counter[index]++; // 해당 알파벳의 개수 카운트
        }
        // 가장 개수(count)가 많은 알파벳 찾기
        int maxCount = 0;
        int maxIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (counter[i] > maxCount) {
                maxCount = counter[i];
                maxIndex = i;
            }
        }
        // 가장 개수(count)가 많은 찾기 2개 이상인지 확인
        boolean duplicated = false;
        for (int i = 0; i < 26; i++) {
            if (counter[i] == maxCount && i != maxIndex) {
                duplicated = true;
            }
        }
        if (duplicated) System.out.println("?");
        else System.out.println(Character.toUpperCase((char) (maxIndex + 'a')));
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
