package Baekjoon.dj1087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class B2470 {

    public int[] solveByTwoPointer(ArrayList<Integer> densityList) {
        densityList.sort(Integer::compareTo);
//        System.out.println(densityList);
        int leftIndex = 0;
        int rightIndex = densityList.size() - 1;
        int[] answer = new int[]{-1, -1, Integer.MAX_VALUE};
        while (leftIndex < rightIndex) {
//            System.out.println(densityList.get(leftIndex) + "|" + densityList.get(rightIndex));
            int mixedDensity = densityList.get(leftIndex) + densityList.get(rightIndex);
//            System.out.println(Math.abs(mixedDensity) + "|" + answer[2]
//                    + "|" + (Math.abs(mixedDensity) < answer[2]));
            if (Math.abs(mixedDensity) < answer[2]) {
                answer = new int[]{leftIndex, rightIndex, Math.abs(mixedDensity)};
            }

            if (mixedDensity > 0) {
                rightIndex--;
            } else if (mixedDensity < 0) {
                leftIndex++;
            } else {
                answer = new int[]{leftIndex, rightIndex, 0};
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> densityList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int density = Integer.parseInt(st.nextToken());
            densityList.add(density);
        }

        B2470 problem = new B2470();

        int[] answer = problem.solveByTwoPointer(densityList);
        StringJoiner joiner = new StringJoiner(" ");

        joiner.add(String.valueOf(densityList.get(answer[0])))
                .add(String.valueOf(densityList.get(answer[1])));
        System.out.println(joiner);
        br.close();
    }
}
