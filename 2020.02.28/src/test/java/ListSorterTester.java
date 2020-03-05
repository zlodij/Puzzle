import puzzle.threads.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTester {
    public static void main(String[] args) {
        List<Integer> src = new ArrayList<>(Arrays.asList(15, 24, 3, 22, 75, -18, 99, 98, -47, 33, 11, 77, 1, 6, 5));
        System.out.println("source: \t" + src.toString());

        ListSorter sorter = new CallableSorter();
        System.out.println("result: \t" + sorter.sort(src).toString());
    }
}
