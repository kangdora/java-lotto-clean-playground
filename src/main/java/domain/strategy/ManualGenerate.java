package domain.strategy;

import domain.Lotto;

import java.util.Collections;
import java.util.List;

public class ManualGenerate implements LottoStrategy{
    @Override
    public Lotto generateLotto(List<Integer> manualNumbers){
        Collections.sort(manualNumbers);
        return new Lotto(manualNumbers);
    }
}
