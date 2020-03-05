package puzzle.threads;

import java.util.List;

public interface ListSorter {
    /**
     * Sorts a list of integers.
     * @param source a list of integer values.
     * @return a sorted list.
     */
    List<Integer> sort(List<Integer> source);
} // end ThreadSorter
