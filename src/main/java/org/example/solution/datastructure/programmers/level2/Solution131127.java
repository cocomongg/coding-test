package org.example.solution.datastructure.programmers.level2;

import java.util.HashMap;
import java.util.Map;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Solution131127 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"};

        System.out.println(solution.solution(want1, number1, discount1));
    }
    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < want.length; ++i) {
                map.put(want[i], number[i]);
            }

            Map<String, Integer> discountMap = new HashMap<>();
            int left = 0;
            int right = 9;
            for(int i = 0; i < discount.length; ++i) {
                boolean isMatch = true;

                if(i == 0) {
                    for(int j = left; j <= right; ++j) {
                        discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                    }
                } else if(right < discount.length) {
                    discountMap.put(discount[left - 1], discountMap.get(discount[left - 1]) - 1);
                    discountMap.put(discount[right], discountMap.getOrDefault(discount[right], 0) + 1);
                } else {
                    break;
                }

                for(Map.Entry<String, Integer> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if(!discountMap.containsKey(key)) {
                        isMatch = false;
                        break;
                    } else if(discountMap.get(key) != map.get(key)) {
                        isMatch = false;
                        break;
                    }
                }

                if(isMatch) {
                    answer++;
                }
                left++;
                right++;
            }

            return answer;
        }
    }
}

// 문제 풀이: map을 이용하여 사려는 항목과 개수를 맵핑 시키고, 주어진 배열을 순회할 때, 좌측과 우측끝에 포인터를 두어서 10개씩 이동할 때 연산을 최소화 시킴