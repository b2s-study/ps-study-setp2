package Programmers.dj1087;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Privacy {
    LocalDate start;
    String type;

    public Privacy(String s) throws ParseException {
        String[] array = s.split(" ");

        this.start = parseDate(array[0]);
        this.type = array[1];
    }

    public static LocalDate parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateString).toInstant().atZone(ZoneId.of("Asia/Seoul")).toLocalDate();
    }

    public boolean isDestroy(LocalDate today, Map<String, Integer> termMap) {
        LocalDate destroyDate = this.start.plusMonths(termMap.get(this.type));
        return !today.isBefore(destroyDate);
    }
}

public class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        ArrayList<Integer> answer = new ArrayList<>();
        LocalDate todayDate = Privacy.parseDate(today);
        Map<String, Integer> termMap = new HashMap<>();
        for (String each : terms) {
            String[] info = each.split(" ");
            termMap.put(info[0], Integer.parseInt(info[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            Privacy privacy = new Privacy(privacies[i]);
            if (privacy.isDestroy(todayDate, termMap)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws ParseException {
        P150370 p = new P150370();
        p.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        p.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});

        Privacy p1 = new Privacy("2021.05.02 A");

    }

}
