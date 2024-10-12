import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int[] s;
        int sum;
        Node(int[] s, int sum) {
            this.s = s;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Node node) {
            return Integer.compare(node.sum, this.sum);
        }
    }
    public int solution(int[][] scores) {
        // 근무태도 동료평가
        int n = scores.length;
        // 완호 점수
        int wx = scores[0][0];
        int wy = scores[0][1];
        
        // 근무태도 내림차순, 동료평가 내림차순
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                if (s1[0] != s2[0]) return Integer.compare(s2[0],s1[0]);
                return Integer.compare(s2[1],s1[1]);
            }
        });
        
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(scores[0], scores[0][0] + scores[0][1]));
        
        int max = scores[0][1];
        int tmp = scores[0][1];
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            int[] cur = scores[i];
            
            if (cur[0] == scores[i-1][0]) {         // 동일한 근무태도 점수를 가진 경우
                
                if (cur[1] >= max) {
                    list.add(new Node(cur, cur[0] + cur[1]));   
                    continue;
                }
                if (!flag) {
                    list.add(new Node(cur, cur[0] + cur[1]));
                    continue;
                }
            } else if (cur[0] < scores[i-1][0]) {   // 근무태도가 작은 경우
                flag = true;
                max = tmp;
                if (cur[1] >= max) {
                    list.add(new Node(cur, cur[0] + cur[1]));   
                    tmp = Math.max(max, cur[1]); // 새로운 max 값 설정
                    continue;
                }
            }
            
            if (wx == cur[0] && wy == cur[1]) {
                return -1;
            }
            
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        
        int curRank = 1;
        int sameCnt = 1;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int sum = node.sum;
            System.out.println(curRank);
            
            if (node.s[0] == wx && node.s[1] == wy) {
                return curRank;
            }
            
            // 동일한 합계에 대한 처리
            if (sum == list.get(i + 1).sum) {
                sameCnt++;
            } else {
                curRank += sameCnt;
                sameCnt = 1;  // 다음 사람은 새로운 점수 그룹으로 시작
            }

        }
        
        return -1;
    }
}