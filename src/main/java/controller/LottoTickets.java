package controller;

import domain.strategy.AutoGenerate;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<List<Integer>> lottoList = new ArrayList<>();

    public void lotto(){
        int gameTime = view.InputView.getMoney();

        LottoGame autoGame = new LottoGame(new AutoGenerate());

        for (int i=0;i < gameTime; i++){
            addLotto(autoGame.generateLotto(null));
        }

        view.ResultView.printLotto(lottoList);
    }

    private void addLotto(List<Integer> lotto){
        this.lottoList.add(lotto);
    }
}
