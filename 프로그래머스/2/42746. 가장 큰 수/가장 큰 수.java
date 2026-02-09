import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] res = new String[numbers.length];
        
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            res[i] = String.valueOf(numbers[i]);
        }
        if (sum == 0) return "0";
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return (n1+n2).compareTo(n2+n1);
            }
        }); // 오름차순정렬
        for (int i = res.length-1; i >= 0; i--) {
            answer += res[i];
        }
        return answer;
    }
}