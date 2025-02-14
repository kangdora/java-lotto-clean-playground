package controller;

import domain.Lotto;
import domain.LottoRank;
import domain.strategy.AutoGenerate;
import service.LottoService;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoService.setStrategy(new AutoGenerate());

        int gameTotalCount = view.InputView.getMoney();

        for (int count = 0; count < gameTotalCount; count++) {
            lottoService.buyLotto(null);
        }

        List<Lotto> purchasedLottoes = lottoService.getPurchasedLottoes();
        view.ResultView.printUserLotto(purchasedLottoes);

        Lotto winningLotto = view.InputView.getWinningList();
        int bonusNumber = view.InputView.getBonusNumber();

        Map<LottoRank, Integer> lottoResults = lottoService.getResults(winningLotto, bonusNumber);

        view.ResultView.printStatistics(lottoResults, lottoService.getPrizeRate());
    }
}
