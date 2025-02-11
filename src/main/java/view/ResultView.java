package view;

import java.util.List;

public class ResultView {
    // TODO: 구매 로또
    public static void printLotto(List<List<Integer>> AllLotto){
        System.out.println("\n" + AllLotto.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : AllLotto){
            System.out.println(lotto);
        }
    }

    // TODO: 당첨 통계
}
