import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(progresses[i] + speeds[i]);
        }
        
        int start = 0;
        while (!q.isEmpty()) {
            boolean flag = false;
            
            int cnt = 0;
            while (!q.isEmpty() && q.peek() >= 100) {
                q.poll();
                start++;
                cnt++;
                flag = true;
            }
            
            if (flag) list.add(cnt);
            
            for (int i = start; i < progresses.length; i++) {
                int score = q.poll() + speeds[i];
                q.offer(score);
            }
        
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}