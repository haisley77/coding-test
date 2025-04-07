import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int si = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] newArr = new int[commands[i][1] - commands[i][0] + 1];
            int index = 0;
            for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
                newArr[index++] = array[j];
            }
            Arrays.sort(newArr);
            answer[si++] = newArr[commands[i][2]-1];
        }
        return answer;
    }
}