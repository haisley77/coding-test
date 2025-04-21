class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int size = brown + yellow;
        
        
        for (int i = 1; i <= size / 2; i++){
            if (size % i != 0) continue;
            int a = i;
            int b = size / i;   // b가 가로
        
            if ((b - 2) * (a - 2) == yellow) {
                answer[0] = b;
                answer[1] = a;
                break;
            }
            
        }
        
        return answer;
    }
}