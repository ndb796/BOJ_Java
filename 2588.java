import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // b = 385라면,
        int x_1 = b % 10; // 일의 자릿수: 5
        int x_2 = (b / 10) % 10; // 십의 자릿수: 8
        int x_3 = (b / 100); // 백의 자릿수: 3

        System.out.println(a * x_1);
        System.out.println(a * x_2);
        System.out.println(a * x_3);
        System.out.println(a * b);
    }
}
