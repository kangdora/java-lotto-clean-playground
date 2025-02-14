package service;

import domain.Lotto;
import domain.LottoConstants;
import domain.LottoGame;
import domain.LottoRank;
import domain.strategy.LottoStrategy;

import java.util.ArrayList;
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

    public List<List<Integer>> getResults(Lotto winningLotto) {
        List<List<Integer>> results = new ArrayList<>();

        Map<Integer, Integer> resultsMap = lottoGame.calculateResults(winningLotto);

        for (int rank = LottoConstants.MAX_GRADE; rank > 0; rank--) {
            results.add(getResult(resultsMap, rank));
        }

        return results;
    }

    private List<Integer> getResult(Map<Integer, Integer> resultsMap, int rank) {
        List<Integer> result = new ArrayList<>();

        LottoRank lottoRank = LottoRank.getMatchedRankByRank(rank);

        result.add(lottoRank.getMatchCount());
        result.add(lottoRank.getPrizeMoney());
        result.add(resultsMap.get(rank));

        return result;
    }
}
