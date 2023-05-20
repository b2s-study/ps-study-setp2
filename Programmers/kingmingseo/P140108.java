package Programmers.kingmingseo;
public class P140108 {
    public int solution(String s){
        int answer = 0;
        int same = 0;
        int diff = 0;
        char x = s.charAt(0);
        for (int i =0; i < s.length(); i++){
            if (same == diff){
                answer = answer + 1;
                same = 0;
                diff = 0;
                x = s.charAt(i);
            }
            if (x != s.charAt(i)){
                diff += 1;
            }
            else{
                same += 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        P140108 divideString = new P140108();
        System.out.println(divideString.solution("banana"));
        System.out.println(divideString.solution("abracadabra"));    // 6
        System.out.println(divideString.solution("aaabbaccccabba"));
    }
}
