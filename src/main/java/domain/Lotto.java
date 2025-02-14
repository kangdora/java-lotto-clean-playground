package domain;

import java.util.Collections;
import java.util.List;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        if (numbers.size() != 6) {
            throw new ArithmeticException("로또 번호는 6개여야 합니다.");
        }
        numbers = List.copyOf(numbers);
        Collections.sort(numbers);
    }
}
