package view;

import domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printUserLotto(List<Lotto> AllLotto) {
        System.out.println("\n" + AllLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : AllLotto) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printStatistics(List<List<Integer>> rankResults, Double prizeMoneyRate) {
        System.out.println("\n당첨 통계\n---------");

        rankResults.forEach(result ->
                System.out.printf("%d개 일치 (%d원)- %d개\n", result.get(0), result.get(1), result.get(2))
        );

        System.out.printf("총 수익률은 %.2f입니다.\n", prizeMoneyRate);
    }
}
