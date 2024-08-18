package org.example.solution.dynamicProgramming.programmers;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Solution12945 {
    public static void main(String[] args) {
        System.out.println(solution(99999));
    }

    public static int solution(int n) {
        int answer = 0;

        answer = fibonacci(n);

        return answer;
    }

    public static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int[] fibonacciNum = new int[n + 1];
        fibonacciNum[0] = 0;
        fibonacciNum[1] = 1;
        for(int i = 2; i <= n; ++i) {
            fibonacciNum[i] = (fibonacciNum[i-1] + fibonacciNum[i-2]) % 1234567;
        }

        return fibonacciNum[n] % 1234567;
    }
}

// 풀이방법: 피보나치 수를 구할때 재귀함수로 하게 되면 스택오버플로우가 발생한다.(n <= 100,000)
//         그래서 다이나믹프로그래밍을 이용해 for문으로 변경하였다.
// 참고: 큰 수를 입력하게 되면 숫자가 자료형의 범위를 벗어나 제대로 값이 저장되지 않는 문제가 발생한다.
//      문제에서 나머지를 구하라고 하는데, 나머지를 (a + b) % c === (a % c + b % c)가 같다는 방법을 통해 풀면 된다.