package service.converter;

import domain.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 맞춰야 하는 개수, 보너스 값이 있는지, 등수, 상금, 개수
public class LottoResultConverter {
    public static List<List<Integer>> mapToList(Map<LottoRank, Integer> rankResults) {
        return rankResults.entrySet().stream()
                .map(entry -> List.of(
                        entry.getKey().getMatchCount(),
                        entry.getKey().getHasValue(),
                        entry.getKey().getRank(),
                        entry.getKey().getPrizeMoney(),
                        entry.getValue()
                ))
                .collect(Collectors.toList());
    }
}
