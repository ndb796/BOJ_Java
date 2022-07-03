/*
입력: A시 B분
걸리는 시간: C분

[푸는 방법]
1) 입력을 그냥 "분"으로만 바꾸기
2) "분"이 주어졌을 때, 시각을 알려주는 함수를 짜기

[예시]
입력: 17시 40분 + 80분 => 1060분 + 80분 => 1140분

1. 1140를 1440으로 나눈 나머지를 취하기: 총 1140분
2. 60으로 나눈 몫을 시로 취하기: 19시
3. 60으로 나눈 나머지를 분으로 취하기: 0분
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int totalMinute = a * 60 + b + c;
        totalMinute %= 1440;
        int hour = totalMinute / 60;
        int minute = totalMinute % 60;

        System.out.println(hour + " " + minute);
    }
}
