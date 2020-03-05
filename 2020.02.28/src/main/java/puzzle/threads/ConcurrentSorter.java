package puzzle.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Provides functionality for sorting list of Integer values based on usage of {@link java.util.concurrent.Callable} tasks.
 */
public class ConcurrentSorter implements ListSorter {
    private List<Integer> list = new ArrayList<>();

    private synchronized void addValue(Integer value) {
        if(value < 0) {
            list.add(0, value);
        } else {
            list.add(value);
        }
    } // end addInteger

    private void clear() {
        list.clear();
    } // end clear

    public List<Integer> sort(List<Integer> source) {
        ExecutorService service = Executors.newFixedThreadPool(source.size());

        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (Integer integer : source) {
            callableTasks.add(new Sleeper(integer, this));
        }

        clear();

        try {
            service.invokeAll(callableTasks);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        service.shutdown();

        return list;
    } // end sort

    private class Sleeper implements Callable<Integer> {
        private Integer internal;
        private ConcurrentSorter sorter;

        public Sleeper(Integer arg, ConcurrentSorter sorter) {
            internal = arg;
            this.sorter = sorter;
        } // end constructor

        @Override
        public Integer call() throws Exception {
            TimeUnit.SECONDS.sleep(Math.abs(internal));

            sorter.addValue(internal);

            return internal;
        } // end call
    } // end Sleeper
} // end
