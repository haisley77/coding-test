import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] arr = new boolean[n];
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i]) continue;
            Queue<Integer> q = new LinkedList<>();
            arr[i] = true;
            q.offer(i);
            cnt++;
            
            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int j = 0; j < n; j++) {
                    if ((computers[cur][j] != 1) || arr[j]) continue;
                    arr[j] = true;
                    q.offer(j);
                }
            }
        }
        
        return cnt;
    }
}