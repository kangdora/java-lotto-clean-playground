package domain.strategy;

import domain.Lotto;
import domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AutoGenerate implements LottoStrategy{
    @Override
    public Lotto generateLotto(List<Integer> manualNumbers){
        List<Integer> all_lottery = new ArrayList<>(LottoConstants.LOTTO_RANGES);

        Collections.shuffle(all_lottery);

        return new Lotto(all_lottery.subList(0, LottoConstants.LOTTO_LENGTH));
    }
}
