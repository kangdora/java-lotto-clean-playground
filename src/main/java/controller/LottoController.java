package controller;

import service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int gameTotalCount = lottoService.getGameTotalCount(view.InputView.getMoney());
        int manualLottoCount = view.InputView.getManualNumberCount();
        List<List<Integer>> manualLottoes = view.InputView.getManualLottoes(manualLottoCount);

        lottoService.buyManualLottoes(manualLottoes);
        lottoService.buyAutoLottoes(gameTotalCount, manualLottoCount);

        List<List<Integer>> purchasedLottoes = lottoService.getPurchasedLottoes();
        view.ResultView.printUserLotto(purchasedLottoes, manualLottoCount);

        List<Integer> winningLotto = view.InputView.getWinningList();
        int bonusNumber = view.InputView.getBonusNumber();

        List<List<Integer>> lottoResults = lottoService.getResults(winningLotto, bonusNumber);

        view.ResultView.printStatistics(lottoResults, lottoService.getPrizeRate());
    }
}
