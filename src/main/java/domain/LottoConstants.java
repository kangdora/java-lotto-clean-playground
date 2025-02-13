package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConstants {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    public static final List<Integer> LOTTO_RANGES = IntStream.range(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static final Map<Integer, Integer> PRIZE_MAP = createPrizeMap();

    private static Map<Integer, Integer> createPrizeMap() {
        Map<Integer, Integer> prizeMap = new HashMap<>();
        prizeMap.put(3, 5000);
        prizeMap.put(4, 50000);
        prizeMap.put(5, 1500000);
        prizeMap.put(6, 2000000000);
        return prizeMap;
    }
}
