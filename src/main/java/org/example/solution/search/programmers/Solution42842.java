package org.example.solution.search.programmers;

import java.util.List;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Solution42842 {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(10, 2), List.of(8, 1), List.of(24, 24));

        lists.forEach(list -> {
            int[] answer = solution(list.get(0), list.get(1));
            System.out.println(answer[0] + " " + answer[1]);
        });
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        int n = brown + yellow;
        int width = 0;
        int height = 0;
        for(int i = 2; i <= Math.sqrt(n); ++i) {
            if(n % i == 0) {
                width = n / i;
                height = i;

                int outsideN = width * 2 + height * 2 - 4;
                if(outsideN == brown) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}

// 풀이 방법: 주어진 brown과 yellow를 더하면 모든 격자를 알 수 있다. 이 값의 약수 중 하나가 가로, 세로가 된다.
//          약수(예상 가로, 세로)를 통해 구한 테두리 격자의 크기와 주어진 brown의 크기를 비교하여 정확한 가로, 세로를 구한다.