import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {

        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[1000001];
        visited[x] = 1;
        q.offer(x);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            // 목표 지점에 도달하면 최소 연산 횟수 반환
            if (cur == y) {
                return visited[cur] - 1;
            }
            
            if (cur + n <= 1000000 && visited[cur + n] == 0){
                visited[cur+n] = visited[cur] + 1;
                q.offer(cur+n);
            }
            if (cur * 2 <= 1000000 && visited[cur * 2] == 0){
                visited[cur*2] = visited[cur] + 1;
                q.offer(cur*2);
            }
            if (cur * 3 <= 1000000 && visited[cur * 3] == 0){
                visited[cur*3] = visited[cur] + 1;
                q.offer(cur*3);
            }
            
        }
        
        return -1;

    }
}