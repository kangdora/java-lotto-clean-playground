package controller;

import domain.strategy.AutoGenerate;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<List<Integer>> purchasedLottos = new ArrayList<>();

    public void lotto() {
        int gameTime = view.InputView.getMoney();
        LottoGame autoGame = new LottoGame(new AutoGenerate());

        for (int i = 0; i < gameTime; i++) {
            addLotto(autoGame.generateLotto(null));
        }

        view.ResultView.printUserLotto(purchasedLottos);
        List<Integer> winningNumbers = view.InputView.getLottoList();

        view.ResultView.printStatistics(autoGame.calculateResults(purchasedLottos, winningNumbers));
    }

    private void addLotto(List<Integer> lotto) {
        this.purchasedLottos.add(lotto);
    }
}
