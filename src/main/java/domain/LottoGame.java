package domain;

import domain.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> purchasedLottoes = new ArrayList<>();
    private final Map<Integer, Integer> rankResults = initializeMap();

    private final LottoStrategy strategy;

    public LottoGame(LottoStrategy strategy) {
        this.strategy = strategy;
    }

    // TODO: 로또 객체로 바꾸기
    public Lotto generateLotto(List<Integer> manualNumbers) {
        List<Integer> numbers = strategy.generateLotto(manualNumbers);
        return new Lotto(numbers);
    }

    public Map<Integer, Integer> calculateResults(Lotto winningLotto) {

        for (Lotto purchasedLotto : purchasedLottoes) {
            int matchCount = countMatchingnumber(purchasedLotto, winningLotto);
            // boolean hasBonus = purchasedLotto.haveBonusNumber(purchasedLotto, bonusNumber);
            int rank = LottoRank.getMatchedRankByMatchCount(matchCount).getRank();
            updateResult(rankResults, rank);
        }

        return rankResults;
    }

    private int countMatchingnumber(Lotto purchasedLotto, Lotto winningLotto) {
        return Long.valueOf(purchasedLotto.numbers()
                .stream()
                .filter(winningLotto.numbers()::contains)
                .count())
                .intValue();
    }

    private boolean haveBonusNumber(Lotto purchasedLotto, int bonusNumber) {
        return purchasedLotto.numbers().contains(bonusNumber);
    }

    private Map<Integer, Integer> initializeMap() {
        Map<Integer, Integer> initializedMap = new HashMap<>();
        initializedMap.put(1, 0);
        initializedMap.put(2, 0);
        initializedMap.put(3, 0);
        initializedMap.put(4, 0);
        return initializedMap;
    }

    private void updateResult(Map<Integer, Integer> rankResults, int rank) {
        if (rank > 0) {
            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }
    }

    public void addLotto(Lotto lotto) {
        purchasedLottoes.add(lotto);
    }

    public List<Lotto> getPurchasedLottoes() {
        return purchasedLottoes;
    }

    public Double calculatePrizeRate() {
        long totalPrize = 0L;

        for (Map.Entry<Integer, Integer> entry : rankResults.entrySet()) {
            int rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += (long) LottoRank.getPrizeMoneyByRank(rank) * count;
        }
        int totalCost = purchasedLottoes.size() * LottoConstants.LOTTO_PRICE;

        return (double) totalPrize / totalCost;
    }


}
