package view;

import domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        // ADD: 1000원 보다 적을때, 오버플로우 감지, 000으로 안끝나는 경우.
        return sc.nextInt() / LottoConstants.LOTTO_PRICE;
    }

    public static int getManualNumberCount() {
        sc.nextLine();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    // TODO: 수동 구매 번호


    public static List<Integer> getWinningList() {
        sc.nextLine();
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        String[] tokens = input.split("\\s*,\\s*");

        List<Integer> lottoList = new ArrayList<>();

        for (String token : tokens) {
            lottoList.add(Integer.parseInt(token.trim()));
        }
        return lottoList;
    }

    public static int getBonusNumber() {
        sc.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        // ADD: 검증 로직(1~45인지)
        return sc.nextInt();
    }
}
