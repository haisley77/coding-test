import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[truck_weights.length];
        int curWeight = 0;
        int answer = 0;
        int index = 0;
        
        while (!q.isEmpty() || index < truck_weights.length) {
            
            for (int i : q) {
                time[i]++;
            }
            
            if (!q.isEmpty() && time[q.peek()] >= bridge_length) {
                int out = q.poll();
                curWeight -= truck_weights[out];
            }
            
            if (index < truck_weights.length && curWeight + truck_weights[index] <= weight) {
                q.offer(index);
                curWeight += truck_weights[index];
                index++;
            }
            
            answer++;
        }

        
        return answer;
    }
}