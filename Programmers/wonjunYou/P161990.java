package Programmers.wonjunYou;

public class P161990 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, -1, -1};

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(i, answer[0]);
                    answer[1] = Math.min(j, answer[1]);
                    answer[2] = Math.max(i + 1, answer[2]);
                    answer[3] = Math.max(j + 1, answer[3]);
                }
            }
        }

        return answer;
    }
}
