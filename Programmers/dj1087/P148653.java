package Programmers.dj1087;

public class P148653 {
    public int dfs(int step, int count) {
        if (step == 0) {
            return count;
        }
        int floor = step % 10;
        if (floor > 5) {
            return dfs((step / 10) + 1, count + (10 - floor));
        } else if (floor < 5) {
            return dfs(step / 10, count + floor);
        } else {
            return Math.min(dfs(step / 10, count + floor), dfs((step / 10) + 1, count + (10 - floor)));
        }
    }

    public int solution(int storey) {
        return dfs(storey, 0);
    }
}
