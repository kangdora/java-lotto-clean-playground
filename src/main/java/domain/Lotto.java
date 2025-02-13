package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new ArithmeticException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingnumber(List<Integer> winningNumbers) {
        return Long.valueOf(numbers.stream().filter(winningNumbers::contains).count()).intValue();
    }

    public boolean haveBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLottoList(){
        return numbers;
    }
}
