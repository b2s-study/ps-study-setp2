package Programmers.dj1087;

public class P161990 {
    public void updateDragPoints(int[] answer, int row, int col) {
        if (row < answer[0]) {
            answer[0] = row;
        }
        if (col < answer[1]) {
            answer[1] = col;
        }
        if (row + 1 > answer[2]) {
            answer[2] = row + 1;
        }
        if (col + 1 > answer[3]) {
            answer[3] = col + 1;
        }
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length + 1, wallpaper[0].length() + 1, 0, 0};
        for (int row = 0; row < wallpaper.length; row++) {
            for (int col = 0; col < wallpaper[row].length(); col++) {
                if (wallpaper[row].charAt(col) == '#') {
                    updateDragPoints(answer, row, col);
                }
            }
        }

        return answer;
    }
}
