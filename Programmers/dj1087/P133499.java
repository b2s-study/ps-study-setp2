package Programmers.dj1087;

public class P133499 {
    public static boolean canSpeak(String s) {
        String before = "";
        while (s.length() != 0) {
            switch (s.charAt(0)) {
                case 'a':
                    if (!s.startsWith("aya") || before.equals("aya")) return false;
                    s = s.substring(3);
                    before = "aya";
                    break;
                case 'y':
                    if (!s.startsWith("ye") || before.equals("ye")) return false;
                    s = s.substring(2);
                    before = "ye";
                    break;
                case 'w':
                    if (!s.startsWith("woo") || before.equals("woo")) return false;
                    s = s.substring(3);
                    before = "woo";
                    break;
                case 'm':
                    if (!s.startsWith("ma") || before.equals("ma")) return false;
                    s = s.substring(2);
                    before = "ma";
                    break;
                default:
                    return false;
            }
        }

        return true;
    }

    public int solution(String[] babbling) {
        int answer = 0;

        for (String each: babbling) {
            if (canSpeak(each)) {
                System.out.println(each);
                answer++;
            }
        }

        return answer;
    }
}
