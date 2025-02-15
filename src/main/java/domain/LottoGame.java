package domain;

import domain.strategy.AutoGenerate;
import domain.strategy.LottoStrategy;

import java.util.*;

public class LottoGame {
    private final List<Lotto> purchasedLottoes = new ArrayList<>();
    private final Map<LottoRank, Integer> rankResults = new HashMap<>();

    private final LottoStrategy strategy;

    public LottoGame(LottoStrategy strategy) {
        this.strategy = strategy;
        initializeRankResults();
    }

    public void buyManualLotto(List<Lotto> lottoes) {
        purchasedLottoes.addAll(lottoes);
    }

    public void buyAutoLotto() {
        LottoStrategy strategy = new AutoGenerate();
        purchasedLottoes.add(strategy.generateLotto(null));
    }

    public Map<LottoRank, Integer> calculateResults(Lotto winningLotto, int bonusNumber) {
        for (Lotto purchasedLotto : purchasedLottoes) {
            LottoRank rank = determineLottoRank(purchasedLotto, winningLotto, bonusNumber);
            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }
        return rankResults;
    }

    private LottoRank determineLottoRank(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = countMatchingNumber(purchasedLotto, winningLotto);
        boolean hasBonus = purchasedLotto.numbers().contains(bonusNumber);
        return LottoRank.getMatchedRankByMatchCount(matchCount, hasBonus);
    }

    private int countMatchingNumber(Lotto purchasedLotto, Lotto winningLotto) {
        return Long.valueOf(purchasedLotto.numbers()
                .stream()
                .filter(winningLotto.numbers()::contains)
                .count())
                .intValue();
    }

    private void initializeRankResults() {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        Collections.reverse(ranks);

        for (LottoRank rank : ranks) {
            rankResults.put(rank, 0);
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

        for (Map.Entry<LottoRank, Integer> entry : rankResults.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += (long) rank.getPrizeMoney() * count;
        }

        int totalCost = purchasedLottoes.size() * LottoConstants.LOTTO_PRICE;

        return (double) totalPrize / totalCost;
    }
}
