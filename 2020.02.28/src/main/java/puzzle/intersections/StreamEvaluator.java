package puzzle.intersections;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEvaluator implements IntersectionEvaluator {
    public Optional<Integer> min(List<Integer>... lists) {
        Optional<Integer> result = Optional.empty();

        // Map every number with a number of its appearance in lists
        Map<Integer, Integer> cache = new HashMap<>();
        // Look through all list to calculate a number of occurrences for every entry
        for (List<Integer> list : lists) {
            Set<Integer> processed = new HashSet<>();

            list.forEach(integer -> {
                int appearance = 1;
                if (cache.containsKey(integer)) {
                    // For duplicates do not increment counter of occurrences
                    appearance = processed.contains(integer)
                            ? cache.get(integer)
                            : cache.get(integer) + appearance;
                }
                cache.put(integer, appearance);
                // Mark current item as processed for current list
                processed.add(integer);
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