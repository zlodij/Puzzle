package puzzle.intersections;

import java.util.List;
import java.util.Optional;

public interface IntersectionEvaluator {
    /**
     * Evaluates a minimal intersection value for all lists.
     * @param lists lists of integer values.
     * @return a minimal intersection value.
     */
    Optional<Integer> min(List<Integer>...lists);
} // end MinIntersectionEvaluator
