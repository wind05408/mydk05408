package com.dk.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Created by dk05408 on 2016-11-06.
 */
public class LambdaTest1 {
    public static void main(String p[]){
        items.stream().filter(s -> s.contains("B")).forEach(System.out::println);
//test2();

/*        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str)->true);
        System.out.println("Print no language : ");
        filter(languages, (str)->false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);*/
    }
    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }

    public static void test(){
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }

        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum
                + cost).get();
        System.out.println(bill);

        costBeforeTax.stream().map((cost) ->cost+.12*cost).forEach(System.out::println);
        }

    public static void test2(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt((x) ->x*12).summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

        BiFunction<Integer, Integer, Integer> multiplier =
                (i1, i2) -> i1 * i2; //you can’t omit parenthesis here!



    }

    private static List<String> items = new ArrayList<>();

    static {
        items.add("A");
        items.add("BC");
        items.add("C");
        items.add("BD");
        items.add("E");
    }


}
