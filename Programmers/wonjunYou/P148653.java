package Programmers.wonjunYou;

public class P148653 {
    int answer = Integer.MAX_VALUE;

    public int solution(int storey) {
        dfs(storey, 0);

        return answer;
    }

    public void dfs(int storey, int count) {
        if (count > answer) {
            return;
        }

        if (storey == 0) {
            answer = count;

        } else {
            int digit = storey % 10;

            dfs(Math.round(storey / 10), count + digit);

            dfs(Math.round(storey / 10) + 1, count + (10 - digit));
        }
    }
}
