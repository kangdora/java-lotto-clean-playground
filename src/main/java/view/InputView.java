package view;

import domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // TODO: 구입 돈
    public static int getMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        // FIXME: 1000원 보다 적을때, 오버플로우 감지, 000으로 안끝나는 경우.
        return scanner.nextInt() / 1000;
    }

    // TODO: 수동 구매 개수

    // TODO: 수동 구매 번호

    // TODO: 지난 주 당첨 번호
    public static List<Integer> getLottoList() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine();

        String[] tokens = input.split(", ");

        List<Integer> lottoList = new ArrayList<>();

        for (String token : tokens) {
            lottoList.add(Integer.parseInt(token.trim()));
        }

        return lottoList;
    }

    // TODO: 보너스 볼
}
