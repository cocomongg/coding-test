package org.example.solution.sort.programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class Solution12939 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String answer = "";

        List<Integer> sortedNumList = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        Integer minNumStr = sortedNumList.get(0);
        Integer maxNumStr = sortedNumList.get(sortedNumList.size() - 1);

        answer = minNumStr + " " + maxNumStr;
        System.out.println(answer);
    }
}

/*
풀이방법: 문자열을 배열로 변환하여 정렬 후 최대 최소 구하기
*/