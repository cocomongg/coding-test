package org.example.solution.implementation.programmers;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class Solution12980 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nArr = {5, 6, 5000};

        for(int n : nArr) {
            System.out.println(solution.solution(n));
        }
    }

     static class Solution {
        public int solution(int n) {
            int ans = 0;

            if(n == 1) {
                return 1;
            }

            while(n != 1) {
                if(n % 2 != 0) {
                    ans += 1;
                    n -= 1;
                }

                n /= 2;
            }

            return ans +1 ;
        }
    }
}

// 풀이방법: 최소를 구하기 위해서는 주어진 수를 2로 나눌 수 있는 경우를 최대한 많이 만들게 되면 문제에서 원하는 최소값을 구할 수 있다.
