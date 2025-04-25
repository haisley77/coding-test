import java.util.*;

class Solution {
    boolean[] visited;
    int[] res;
    int maxCnt;
    boolean flag = false;
    public int solution(int k, int[][] dungeons) {
        
        // 던전 탐색 순서를 정한다. 던전의 최대 개수는 8
        
        for (int i = 1; i <= dungeons.length; i++) {
            visited = new boolean[dungeons.length];
            res = new int[i];
            perm(0, i, dungeons, k);
            flag = false;
        }
    
        return maxCnt;
    }
    
    private void perm(int cnt, int n, int[][] dungeons, int k) {
        
        if (flag) return;
        
        if (cnt == n) {
            
            for (int i = 0; i < n; i++) {
                int[] cur = dungeons[res[i]];
                if (cur[0] > k) return;
                if (cur[1] > k) return;
                k -= cur[1];
            }
            
            if (n > maxCnt) {
                flag = true;
                maxCnt = n;
            }
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            res[cnt] = i;
            perm(cnt+1, n, dungeons, k);
            visited[i] = false;
        }
    }
}