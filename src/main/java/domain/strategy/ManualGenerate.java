package domain.strategy;

import java.util.List;

public class ManualGenerate implements LottoStrategy{
    @Override
    public List<Integer> generateLotto(List<Integer> manualNumbers){
        return manualNumbers;
    }
}
