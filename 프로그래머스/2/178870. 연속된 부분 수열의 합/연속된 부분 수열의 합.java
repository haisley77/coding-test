class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        answer[0] = answer[1] = n-1;
        
        int sum = 0;
        int end = n-1;
        
        int min = n;
        
        
        for (int i = n-1; i >= 0; i--) {
            sum += sequence[i];
            if (sum == k) {
                if (min >= end - i + 1) {
                    answer[0] = i;
                    answer[1] = end;
                    min = end - i + 1;
                }
                sum -= sequence[end];
                end--;
            } else if (i != 0 && sum > k) {
                sum -= sequence[end];
                end--;
            }
        }
        
        
        return answer;
    }
}