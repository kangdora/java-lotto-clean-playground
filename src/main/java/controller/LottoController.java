package controller;

import domain.Lotto;
import domain.LottoRank;
import domain.strategy.AutoGenerate;
import domain.strategy.ManualGenerate;
import service.LottoService;

import java.util.List;
import java.util.Map;

public class LottoController {
    /*
    컨트롤러는 무슨 역할을 해야하는가?
    InputView에서 제공해주는 값들을 받고 서비스로 넘겨준 후 서비스에서 ResultvView로 넘기면 된다
     */
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoService.setStrategy(new ManualGenerate());

        int gameTotalCount = view.InputView.getMoney();
        int manualLottoCount = view.InputView.getManualNumberCount();
        List<Lotto> manualLottoes = view.InputView.getManualLottoes(manualLottoCount);

        lottoService.buyManualLottoes(manualLottoCount);

        lottoService.setStrategy(new AutoGenerate());

        lottoService.buyAutoLottoes();

        List<Lotto> purchasedLottoes = lottoService.getPurchasedLottoes();
        view.ResultView.printUserLotto(purchasedLottoes, manualLottoCount);

        Lotto winningLotto = view.InputView.getWinningList();
        int bonusNumber = view.InputView.getBonusNumber();

        List<List<Integer>> lottoResults = lottoService.getResults(winningLotto, bonusNumber);

        view.ResultView.printStatistics(lottoResults, lottoService.getPrizeRate());
    }
}
