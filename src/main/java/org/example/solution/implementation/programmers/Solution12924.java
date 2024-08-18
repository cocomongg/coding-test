package org.example.solution.implementation.programmers;


// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class Solution12924 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int start = 0;

        for(int i = 1; i <= n/2; ++i ) {
            sum = 0;
            start = i;
            while(sum <= n) {
                if(sum == n) {
                    answer++;
                    break;
                }

                sum += start++;
           }
        }

        return answer + 1;
    }
}
