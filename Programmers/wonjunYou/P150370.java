package Programmers.wonjunYou;

import java.util.*;

class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        String[] todayInfo = today.split("\\.");
        int year = Integer.parseInt(todayInfo[0]);
        int month = Integer.parseInt(todayInfo[1]);
        int day = Integer.parseInt(todayInfo[2]);

        Map<String, Integer> termsInfo = parseTermsForMap(terms);

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];

            String startDate = privacy.split(" ")[0];
            int validDays = (termsInfo.get(privacy.split(" ")[1])) * 28;

            int elapsedDate =
                    ((year - Integer.parseInt(startDate.split("\\.")[0])) * 12 * 28) +
                            ((month - Integer.parseInt(startDate.split("\\.")[1])) * 28) +
                            ((day - Integer.parseInt(startDate.split("\\.")[2])));

            if (elapsedDate >= validDays) {
                result.add(i + 1);
            }
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public Map<String, Integer> parseTermsForMap(String[] terms) {
        Map<String, Integer> termsInfo = new HashMap<String, Integer>();

        for (String term : terms) {
            String[] tmp = term.split(" ");
            termsInfo.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        return termsInfo;
    }
}
