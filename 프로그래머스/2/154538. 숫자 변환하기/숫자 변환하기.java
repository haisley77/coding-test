import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {

        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[y+1];
        visited[x] = 1;
        q.offer(x);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == y) {
                return visited[cur] - 1;
            }
            
            if (cur + n <= y && visited[cur + n] == 0){
                visited[cur+n] = visited[cur] + 1;
                q.offer(cur+n);
            }
            if (cur * 2 <= y && visited[cur * 2] == 0){
                visited[cur*2] = visited[cur] + 1;
                q.offer(cur*2);
            }
            if (cur * 3 <= y && visited[cur * 3] == 0){
                visited[cur*3] = visited[cur] + 1;
                q.offer(cur*3);
            }
            
        }
        
        return -1;

    }
}