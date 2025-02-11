package view;

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

    // TODO: 보너스 볼
}
