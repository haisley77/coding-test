import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b)->Integer.compare(a[1], b[1]));
        
        int e = 0;
        for (int[] cur: targets) {
            
            if (cur[0] >= e) {
                answer++;
                e = cur[1];
            }
        }
        
        return answer;
    }
}