package Programmers.wonjunYou;

public class P140108 {
    public int solution(String s) {
        int[] counter = initCounter();
        char letter = s.charAt(0);
        boolean doReset = false;

        int result = 1;

        for (int idx = 0; idx < s.length() - 1; idx++) {
            if (doReset) {
                counter = initCounter();
                letter = s.charAt(idx);
                doReset = false;
            }

            if (s.charAt(idx) == letter) {
                counter[0] += 1;
            } else {
                counter[1] += 1;
            }

            if (checkCounter(counter)) {
                result += 1;
                doReset = true;
            }
        }

        return result;
    }

    private boolean checkCounter(int[] counter) {
        if (counter[0] == counter[1]) {
            return true;
        }

        return false;
    }

    private int[] initCounter() {
        return new int[] {0, 0};
    }
}
