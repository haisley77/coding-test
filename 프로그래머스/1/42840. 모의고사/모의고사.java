import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] arr1 = new int[answers.length];
        int[] arr2 = new int[answers.length];
        int[] arr3 = new int[answers.length];
        
        int[] temp2 = {1,3,4,5};
        int[] temp3 = {3,3,1,1,2,2,4,4,5,5};
        
        int index = 0;
        
        for (int i = 0; i < answers.length; i++) {
            
            // 수포자1
            arr1[i] = (i % 5) + 1;
            
            // 수포자2
            if (i % 2 == 0) {
                arr2[i] = 2;
            } else {
                arr2[i] = temp2[index];
                index = (index + 1) % 4;
            }
            
            // 수포자3
            arr3[i] = temp3[i % 10];
        }
        
        int sum1 = 0, sum2 = 0, sum3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (arr1[i] == answers[i]) sum1++;
            if (arr2[i] == answers[i]) sum2++;
            if (arr3[i] == answers[i]) sum3++;
        }
        
        int max = Math.max(sum1, Math.max(sum2, sum3));
        
        List<Integer> list = new ArrayList<>();
        
        if (sum1 == max) list.add(1);
        if (sum2 == max) list.add(2);
        if (sum3 == max) list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
