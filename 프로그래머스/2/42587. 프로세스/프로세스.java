import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        int[] executed = new int[n];
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i,priorities[i]});
        }
    
        int index = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int size = q.size();
            
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int[] next = q.poll();
                if (cur[1] < next[1]) {
                    flag = true;
                }
                q.offer(next);
            }
            if (flag) {
                q.offer(cur);
            } else {
                executed[cur[0]] = index;
                index++;
            }
            
        }
        
        
        return executed[location];
    }
}