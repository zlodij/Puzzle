package puzzle.intersections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEvaluator implements IntersectionEvaluator {
    public Optional<Integer> min(List<Integer>... lists) {
        Optional<Integer> result = Optional.empty();

        // Map every number with a number of its appearance in lists
        Map<Integer, Integer> cache = new HashMap<>();
        // Look through all list to calculate a number of occurrences for every entry
        for (List<Integer> list : lists) {
            list.forEach(integer -> {
                int appearance = 1;
                if (cache.containsKey(integer)) {
                    appearance += cache.get(integer);
                }
                cache.put(integer, appearance);
            });
        }

        // Get a sorted list of all lists' entries
        List<Integer> sorted = cache.keySet().stream().sorted().collect(Collectors.toList());
        // Look for minimal intersection value
        for (Integer number : sorted) {
            int appearance = cache.get(number);
            // Use current number as a result if it exists in all lists
            if (appearance == lists.length) {
                result = Optional.of(number);
                break;
            }
        }

        return result;
    } // end min
} // end TaskIntersection