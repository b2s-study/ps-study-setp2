package Programmers.kingmingseo;

import java.util.Arrays;

class P42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

       int i =0;
        for(i=0; i<completion.length; i++)
            if(!participant[i].equals(completion[i]))
                break;


        return participant[i];
    }
    public static void main(String[] args){
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        P42576 sol = new P42576();
        System.out.println(sol.solution(part, comp));
    }
}
