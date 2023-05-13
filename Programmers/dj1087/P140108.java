package Programmers.dj1087;

public class P140108 {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int isX = 1;
        int notX = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isX == 0 && notX == 0) {
                x = s.charAt(i);
                isX++;
                continue;
            }
            if (s.charAt(i) == x) {
                isX++;
            }else {
                notX++;
            }
            if (isX == notX) {
                answer++;
                isX = 0;
                notX = 0;
            }
            System.out.println(String.valueOf(x)+"|"+ String.valueOf(s.charAt(i))+"|"+
                    String.valueOf(isX)+"|"+ String.valueOf(notX)+"|"+ String.valueOf(answer));
        }
        if (isX != notX) {
            answer++;
        }
        return answer;

    }
}
