package org.example.solution.datastructure.programmers.level2;

import java.util.*;

public class Solution138476 {
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k2 = 2;
        int[] tangerine2 = {1, 1, 1, 1, 2, 2, 2, 3};

        int k3 = 6;
        int[] tangerine3 = {1, 2, 3, 4, 4, 5, 5};

        Solution solution = new Solution();
        System.out.println(solution.solution(k1, tangerine1));
        System.out.println(solution.solution(k2, tangerine2));
        System.out.println(solution.solution(k3, tangerine3));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < tangerine.length; ++i) {
                Integer value = map.getOrDefault(tangerine[i], 0);
                map.put(tangerine[i], value+1);
            }

            ArrayList<Integer> keys = new ArrayList<>(map.keySet());
            keys.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o2) - map.get(o1);
                }
            });

            for(int i = 0; i < keys.size(); ++i) {
                k -= map.get(keys.get(i));
                answer++;
                if(k <= 0) {
                    break;
                }
            }

            return answer;
        }

//        public int solution(int k, int[] tangerine) {
//            int answer = 0;
//
//            Arrays.sort(tangerine);
//            Map<Integer, Integer> map = new HashMap<>();
//            int before = tangerine[0];
//            int count = 1;
//            for(int i = 1; i < tangerine.length; ++i) {
//                if(before != tangerine[i]) {
//                    if(map.containsKey(count)) {
//                        Integer temp = map.get(count);
//                        map.put(count, ++temp);
//                    } else {
//                        map.put(count, 1);
//                    }
//                    before = tangerine[i];
//                    count = 1;
//                } else {
//                    count++;
//                }
//            }
//
//            if(map.containsKey(count)) {
//                Integer temp = map.get(count);
//                map.put(count, ++temp);
//            } else {
//                map.put(count, 1);
//            }
//
//            Set<Integer> keySet = map.keySet();
//            ArrayList<Integer> keyList = new ArrayList<>(keySet);
//            Integer[] keyArr = new Integer[keyList.size()];
//            for(int i = 0; i < keyList.size(); ++i) {
//                keyArr[i] = keyList.get(i);
//            }
//
//           Arrays.sort(keyArr, Comparator.reverseOrder());
//
//            for(int i = 0; i < keyArr.length; ++i) {
//                boolean isFinish = false;
//                for(int j = 1; j <= map.get(keyArr[i]); ++j) {
//                    k -= keyArr[i];
//                    answer++;
//                    if(k <= 0) {
//                        isFinish = true;
//                        break;
//                    }
//                }
//
//                if(isFinish) {
//                    break;
//                }
//            }
//
//            return answer;
//        }
    }
}


// 풀이방법: map을 이용하고 내림차순으로 정렬 하여 풀이했다.
//         두번째 풀이는 key를 상자안에 든 개수로, value를 같은 개수의 상자들의 총합이다. 그후 내림차순으로 정렬하고 최소 개수를 구했다.
//         첫번째 풀이는 key를 상자의 종류, value는 종류에 해당하는 개수이다. 그후 위와 같이 내림차순으로 정렬하고 최소 개수를 구했다.
// 참고:    내림차순 정렬 List: list.sort(Comparator.reverseOrder());
//                   Array: Arrays.sort(arr, Comparator.reverseOrder())