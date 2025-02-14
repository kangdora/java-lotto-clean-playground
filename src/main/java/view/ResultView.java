package view;

import domain.Lotto;
import domain.LottoRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printUserLotto(List<Lotto> AllLotto, int manualLottoCount) {
        System.out.println("\n" + AllLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : AllLotto) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printStatistics(Map<LottoRank, Integer> rankResults, Double prizeMoneyRate) {
        System.out.println("\n당첨 통계\n---------");

        for (LottoRank rank : LottoRank.values()) {
            printRankResult(rank, rankResults.getOrDefault(rank, 0));
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", prizeMoneyRate);
    }

    private static void printRankResult(LottoRank rank, Integer count) {
        if (rank == LottoRank.NONE) return;

        if (rank.hasBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n",
                    rank.getMatchCount(), rank.getPrizeMoney(), count);
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개\n",
                rank.getMatchCount(), rank.getPrizeMoney(), count);
    }
}
