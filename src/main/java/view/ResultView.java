package view;

import java.util.List;
import java.util.Map;

public class ResultView {
    // TODO: 구매 로또
    public static void printUserLotto(List<List<Integer>> AllLotto) {
        System.out.println("\n" + AllLotto.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : AllLotto) {
            System.out.println(lotto);
        }
    }

    // TODO: 당첨 통계
    public static void printStatistics(Map<Integer, Integer> rankResults) {
        System.out.println("\n당첨 통계\n---------");

        Long prizeMoney = 0L;

        for (int matchCount : domain.LottoConstants.PRIZE_MAP.keySet()) {
            int count = rankResults.getOrDefault(matchCount, 0);
            int prize = domain.LottoConstants.PRIZE_MAP.get(matchCount);
            System.out.println(matchCount + "개 일치 (" + prize + "원) - " + count + "개");
        }
    }
}
