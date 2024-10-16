class Solution {

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        answer[n-1] = -1;
        int max = numbers[n-1];
        

        for (int i = n-2; i >= 0; i--) {
            if (max <= numbers[i]) {    // 최댓값 
                answer[i] = -1;
                max = numbers[i];
                continue;
            }
            if (numbers[i] == numbers[i+1]) {
                answer[i] = answer[i+1];
            } 
            if (numbers[i] > numbers[i+1]) {
                if (numbers[i] < answer[i+1]) {
                    answer[i] = answer[i+1];
                } else {
                    int index = i+1;
                    while (index <= n-1){
                        if (answer[index] == -1 || numbers[i] < answer[index]) break;
                        index++;
                    };
                    answer[i] = answer[index];
                }
            }

            if (numbers[i] < numbers[i+1]) {
                answer[i] = numbers[i+1];
            }
            

        }
        return answer;
    }
}