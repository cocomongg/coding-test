package org.example.solution.sort.programmers.level2;

import java.util.Arrays;

public class Solution12941 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        System.out.println(solution(A, B));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; ++i) {
            answer += (A[i] * B[A.length - i]);
        }

        return answer;
    }
}

// 문제풀이: 각 배열을 오름차순으로 정렬한 뒤, 최소와 최대를 곱해서 누적하면 최소값을 구할 수 있다.
// 참고: primitive type의 array를 정렬할 때 Arrays.sort()를 사용하면 Arrays.stream().sorted를 사용할 때보다 시간복잡도가 좋다.