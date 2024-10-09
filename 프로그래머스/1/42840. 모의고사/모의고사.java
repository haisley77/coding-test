class Solution {
    public int[] solution(int[] answers) {

        int max = 0;
        int[] S = new int[3];
        int tr = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == tr+1) S[0]++;
            tr = (tr + 1) % 5;
        }
        if (max < S[0]) max = S[0];
        tr = 0;
        for (int i = 0; i < answers.length; i++) {
            if (tr == 0 && answers[i] == 2) S[1]++;
            if (tr == 1 && answers[i] == 1) S[1]++;
            if (tr == 2 && answers[i] == 2) S[1]++;
            if (tr == 3 && answers[i] == 3) S[1]++;
            if (tr == 4 && answers[i] == 2) S[1]++;
            if (tr == 5 && answers[i] == 4) S[1]++;
            if (tr == 6 && answers[i] == 2) S[1]++;
            if (tr == 7 && answers[i] == 5) S[1]++;
            tr = (tr + 1) % 8;
        }
        if (max < S[1]) max = S[1];
        tr = 0;
        for (int i = 0; i < answers.length; i++) {
            if (tr == 0 && answers[i] == 3) S[2]++;
            if (tr == 1 && answers[i] == 3) S[2]++;
            if (tr == 2 && answers[i] == 1) S[2]++;
            if (tr == 3 && answers[i] == 1) S[2]++;
            if (tr == 4 && answers[i] == 2) S[2]++;
            if (tr == 5 && answers[i] == 2) S[2]++;
            if (tr == 6 && answers[i] == 4) S[2]++;
            if (tr == 7 && answers[i] == 4) S[2]++;
            if (tr == 8 && answers[i] == 5) S[2]++;
            if (tr == 9 && answers[i] == 5) S[2]++;
            tr = (tr + 1) % 10;
        }
        if (max < S[2]) max = S[2];
        
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (max == S[i]) cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (max == S[i]) answer[idx++] = i+1; 
        }
        
        return answer;
    }
}