package domain;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        numbers = numbers.stream()
                .sorted()
                .toList();
    }
}
