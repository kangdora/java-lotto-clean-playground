package service;

import domain.Lotto;
import domain.LottoGame;
import domain.strategy.LottoStrategy;
import service.converter.LottoResultConverter;

import java.util.List;

public class LottoService {
    /*
    이 클래스는 전반적인 흐름을 다뤄야 함
    컨트롤러에서 제공해주는 값을 받고 도메인의 Game에 넣어서 값을 받아주는게 목적임.
    여기서 제공하는 값에서는 Lotto 객체가 포함되면 안됨. 그럼 Lottoes클래스에서 이 넘어가는 데이터를 처리해줘야 함.

     */

    private LottoGame lottoGame;

    public LottoService() {}

    public void setStrategy(LottoStrategy strategy) {
        this.lottoGame = new LottoGame(strategy);
    }

    public void buyLotto(List<Integer> manualNumbers) {
        Lotto lotto = lottoGame.generateLotto(manualNumbers);
        lottoGame.addLotto(lotto);
    }

    public List<Lotto> getPurchasedLottoes() {
        return lottoGame.getPurchasedLottoes();
    }

    public Double getPrizeRate() {
        return lottoGame.calculatePrizeRate();
    }

    public List<List<Integer>> getResults(Lotto winningLotto, int bonusNumber) {
        return LottoResultConverter.mapToList(lottoGame.calculateResults(winningLotto, bonusNumber));
    }
}
