package org.example.solution.implementation.programmers;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Solution12985 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution.solution(n, a, b));

        n = 16;
        a = 2;
        b = 9;
        System.out.println(solution.solution(n, a, b));
    }

    static class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            int temp = 0;
            if(a > b) {
                temp = a;
                a = b;
                b = temp;
            }

            while(true) {
                if(a % 2 == 1 && a +1 == b) {
                    answer++;
                    break;
                }

                if(a % 2 == 1) {
                    a++;
                }

                if(b % 2 == 1) {
                    b++;
                }

                a /= 2;
                b /= 2;

                answer++;
            }

            return answer;
        }
    }
}
// 풀이방법:  a,b가 같은 그룹에 속할 때까지 계속 2로 나누기