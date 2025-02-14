package domain.strategy;

import domain.Lotto;

import java.util.List;

public interface LottoStrategy {
    Lotto generateLotto(List<Integer> manualNumbers);
}
