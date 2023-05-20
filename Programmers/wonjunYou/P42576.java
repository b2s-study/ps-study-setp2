package Programmers.wonjunYou;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> counter = new HashMap<>();

        for (String member : participant) {
            if (counter.containsKey(member)) {
                // map.get(key);
                // map.put(key, value);
                int count = counter.get(member);
                counter.put(member, count + 1);
            } else {
                counter.put(member, 1);
            }
        }

        return findMemberGiveUp(counter, completion);
    }

    private String findMemberGiveUp(Map<String, Integer> counter, String[] completion) {
        for (String member : completion) {
            int count = counter.get(member);
            counter.put(member, count - 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return "";
    }
}
