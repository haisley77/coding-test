import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] cur = commands[i];
            
            int[] arr = new int[cur[1] - cur[0] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = array[cur[0] - 1 + j];
            }
            Arrays.sort(arr);
            answer[i] = arr[cur[2] - 1];
            
        }
        
        return answer;
    }
}