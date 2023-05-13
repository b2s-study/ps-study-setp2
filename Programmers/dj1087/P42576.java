package Programmers.dj1087;

import java.util.Arrays;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length; i++) {
            if (i == participant.length - 1) {
                answer = participant[i];
                break;
            }
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
