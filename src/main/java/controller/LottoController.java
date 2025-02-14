package controller;

import domain.Lotto;
import domain.strategy.AutoGenerate;
import service.LottoService;

import java.util.List;

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
        List<List<Integer>> lottoResults = lottoService.getResults(winningLotto);

        view.ResultView.printStatistics(lottoResults, lottoService.getPrizeRate());
    }
}
