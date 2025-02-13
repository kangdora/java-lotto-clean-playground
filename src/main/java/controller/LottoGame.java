package controller;

import domain.strategy.LottoStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoStrategy strategy;

    public LottoGame(LottoStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> generateLotto(List<Integer> manualNumbers) {
        return strategy.generateLotto(manualNumbers);
    }

    public Map<Integer, Integer> calculateResults(List<List<Integer>> purchasedLottos, List<Integer> winningNumbers) {
        Map<Integer, Integer> result = initializeResult();

        for (List<Integer> purchasedLotto : purchasedLottos) {
            int matchCount = countMatchingnumber(purchasedLotto, winningNumbers);
            // boolean hasBonus = isMatchingBonus(purchasedLotto, bonusNumber);
            int rank = calculateRank(matchCount);
            updateResult(result, rank);
        }

        return result;
    }

    private int countMatchingnumber(List<Integer> purchasedLotto, List<Integer> winningNumbers) {
        return Long.valueOf(purchasedLotto.stream().filter(winningNumbers::contains).count()).intValue();
    }

    private boolean isMatchingBonus(List<Integer> purchasedLotto, int bonusNumber) {
        return purchasedLotto.contains(bonusNumber);
    }

    private int calculateRank(int matchCount) {
        if (matchCount == 6) return 1;
        if (matchCount == 5) return 2;
        if (matchCount == 4) return 3;
        if (matchCount == 3) return 4;
        return 0;
    }

    private void updateResult(Map<Integer, Integer> result, int rank) {
        if (rank > 0) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private Map<Integer, Integer> initializeResult() {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        return result;
    }
}
