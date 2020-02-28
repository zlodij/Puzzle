import puzzle.intersections.IntersectionEvaluator;
import puzzle.intersections.StreamEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTester {
    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 7));
        System.out.println("one: \t" + one.toString());

        List<Integer> two = new ArrayList<>(Arrays.asList(52, 43, 7, 25, 10, 13, 75, 62, 70, 1));
        System.out.println("two: \t" + two.toString());

        List<Integer> three = new ArrayList<>(Arrays.asList(15, 24, 3, 22, 75, 18, 99, 98, 47, 33, 11, 77, 1, 6, 5));
        System.out.println("three: \t" + three.toString());

        System.out.println("\n----------------------------");
        IntersectionEvaluator evaluator = new StreamEvaluator();
        System.out.println("result(1): \t" + evaluator.min(one));
        System.out.println("result(2): \t" + evaluator.min(one, two));
        System.out.println("result(3): \t" + evaluator.min(one, two, three));
    } // end main
} // end IntersectionTester
