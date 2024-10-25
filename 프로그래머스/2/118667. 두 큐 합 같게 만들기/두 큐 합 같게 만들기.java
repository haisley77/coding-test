import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long s1 = 0;
        for(int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            q1.offer(queue1[i]);
        }
        long s2 = 0;
        for (int i = 0; i < queue2.length; i++) {
            s2 += queue2[i];
            q2.offer(queue2[i]);
        }
        long total = s1 + s2;
        if (total % 2 != 0) return -1;
        
        while (true) {
            // System.out.println(s1 + " " + s2);
            if (answer > (queue1.length + queue2.length) * 2) return -1;
            
            if (s1 < total / 2) {
                int n = q2.poll();
                q1.offer(n);
                s1 += n;
                s2 -= n;
            } else if (s1 > total / 2) {
                int n = q1.poll();
                q2.offer(n);
                s2 += n;
                s1 -= n;
            } else {
                return answer;
            }
            answer++;
        }
         

    }
}