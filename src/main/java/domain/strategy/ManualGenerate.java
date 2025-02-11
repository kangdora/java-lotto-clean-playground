package domain.strategy;

import java.util.Collections;
import java.util.List;

public class ManualGenerate implements LottoStrategy{
    @Override
    public List<Integer> generateLotto(List<Integer> manualNumbers){
        Collections.sort(manualNumbers);
        return manualNumbers;
    }
}
