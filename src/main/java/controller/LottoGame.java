package controller;

import domain.strategy.LottoStrategy;

import java.util.List;

public class LottoGame {
    private final LottoStrategy strategy;

    public LottoGame(LottoStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> generateLotto(List<Integer> manualNumbers){
        return strategy.generateLotto(manualNumbers);
    }
}
