package domain.strategy;

import java.util.List;

public interface LottoStrategy {
    List<Integer> generateLotto(List<Integer> manualNumbers);
}
