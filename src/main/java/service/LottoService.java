package service;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoRank;
import domain.strategy.LottoStrategy;

import java.util.List;
import java.util.Map;

public class LottoService {
    private LottoGame lottoGame;

    public LottoService() {}

    public void setStrategy(LottoStrategy strategy) {
        this.lottoGame = new LottoGame(strategy);
    }

    public void buyLotto(List<Integer> manualNumbers) {
        Lotto lotto = lottoGame.generateLotto(manualNumbers);
        lottoGame.addLotto(lotto);
    }

    public List<Lotto> getPurchasedLottoes() {
        return lottoGame.getPurchasedLottoes();
    }

    public Double getPrizeRate() {
        return lottoGame.calculatePrizeRate();
    }

    public Map<LottoRank, Integer> getResults(Lotto winningLotto, int bonusNumber) {
        return lottoGame.calculateResults(winningLotto, bonusNumber);
    }
}
