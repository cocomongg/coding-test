package org.example.solution.datastructure.programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Solution12981 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer1 = solution.solution(n1, words1);
        System.out.println(answer1[0] + " " + answer1[1]);

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int[] answer2 = solution.solution(n2, words2);
        System.out.println(answer2[0] + " " + answer2[1]);

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] answer3 = solution.solution(n3, words3);
        System.out.println(answer3[0] + " " + answer3[1]);
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            Set<String> usedWords = new HashSet<>();
            usedWords.add(words[0]);
            for(int i = 1; i < words.length; ++i) {
                String currentWord = words[i];
                String beforeWord = words[i - 1];

                usedWords.add(currentWord);
                if( (beforeWord.charAt(beforeWord.length() - 1) != currentWord.charAt(0) )|| (usedWords.size() != i + 1)) {
                    answer[0] = i % n + 1;;
                    answer[1] = i / n + 1;
                    break;
                }
            }

            return answer;
        }
    }

//    static class Solution {
//        public int[] solution(int n, String[] words) {
//            int[] answer = {0, 0};
//
//            int failedIdx = 0;
//            List<String> usedWords = new ArrayList<>();
//            usedWords.add(words[0]);
//            for(int i = 1; i < words.length; ++i) {
//                String word = words[i];
//
//                // 이전에 사용했던 낱말인지
//                boolean isUsed = false;
//                for(int j = 0; j < usedWords.size(); ++j) {
//                    if(usedWords.get(j).equals(word)) {
//                        isUsed = true;
//                    }
//                }
//
//                if(isUsed) {
//                    failedIdx = i;
//                    break;
//                }
//
//                // 이전에 사용했던 낱말의 마지막 문자와 일치하는지
//                char[] wordArr = word.toCharArray();
//                char[] beforeWordArr = usedWords.get(usedWords.size() - 1).toCharArray();
//
//                if(beforeWordArr[beforeWordArr.length - 1] != wordArr[0]) {
//                    failedIdx = i;
//                    break;
//                }
//
//                usedWords.add(word);
//            }
//
//            if(failedIdx != 0) {
//                // 나머지가 사람 번호
//                // 몫이 순서
//                answer[0] = failedIdx % n + 1;
//                answer[1] = failedIdx / n + 1;
//            }
//
//            return answer;
//        }
//    }
}

// 풀이 방법: 주석된 처음 풀이에서는 사용된 낱말들을 배열에 담아 해당 배열을 순회하면서 중복 검사를 진행,
//          두번째 풀이에서는 중복을 검사하기 위해 자료구조 Set을 사용하여 Set의 크기와 현재 인덱스를 통해 중복을 검사
// 참고:     중복 검사 시에는 set을 활용하는 방법을 사용해보기