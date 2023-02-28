package com.logika.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.logika.constans.Operators;
import com.logika.helpers.logichelper.ParseLogics;
import com.logika.helpers.logichelper.Spliterators;
import com.logika.helpers.print.Print;
import com.logika.services.logicops.BasicOperation;
import com.logika.services.logicops.BasicOperationSingelton;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "lgc", description = "compare string logic to boolean", mixinStandardHelpOptions = true)
public class LogicCaller implements Callable<Integer> {

    Spliterators spliterators = new Spliterators();

    @Parameters(type = String.class)
    private String statement;
    @Option(type = Boolean.class, names = { "-T", "--table" }, defaultValue = "false")
    private Boolean verbose;
    private BasicOperation intence;

    /**
     * @param parse jika parse lebih dari 2
     * @return
     */
    public List<Boolean> iterateStatment(List<String> parse) {
        List<Boolean> tempory = new ArrayList<>();
        List<List<Boolean>> component = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        List<Boolean> set1 = new ArrayList<>();
        List<Boolean> set2 = new ArrayList<>();
        try {
            if (parse.size() > 1) {
                for (int r = 0; r < parse.size(); r++) {
                    if ((r % 2) == 0) {
                        final int t = r;
                        String subStatment = parse.get(t);
                        List<Boolean> subLogicTable = spliterators.spliters(subStatment);
                        if (intence.getTableChart().get(subStatment) == null && verbose)
                            Print.printResult(subStatment, subLogicTable);
                        component.add(r / 2, subLogicTable);
                    } else {
                        operator.add(parse.get(r));
                    }
                }
                // set data 1 and data 2 to compare
                set1.addAll(component.get(0));
                set2.addAll(component.get(1));
                iterateToCompare(tempory, component, operator, set1, set2, parse);
                return set1;
            } else {
                return spliterators.spliters(parse.get(0));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + "help");
            Thread.currentThread().interrupt();
            return Collections.emptyList();

        }
    }

    private void iterateToCompare(List<Boolean> tempory, List<List<Boolean>> component, List<String> operator,
            List<Boolean> set1, List<Boolean> set2, List<String> parse) {
        /*
         * compare data from boolean list
         */
        for (int i = 0, y = 1; i < operator.size(); i++) {
            String oprs = operator.get(i);
            if (oprs.equals(Operators.OPERATOR.get(0))) {
                tempory.addAll(BasicOperation.andOps(set1, set2));
            } else if (oprs.equals(Operators.OPERATOR.get(1))) {
                tempory.addAll(BasicOperation.orOps(set1, set2));
            } else if (oprs.equals(Operators.OPERATOR.get(2))) {
                tempory.addAll(BasicOperation.impOps(set1, set2));

            } else if (oprs.equals(Operators.OPERATOR.get(3))) {
                tempory.addAll(BasicOperation.bimpOps(set1, set2));

            } else {
                // nothing to do
            }

            set2.clear();
            try {
                y++;// untuk
                set2.addAll(component.get(y));
            } catch (Exception e) {
                // nothing to do
            }
            set1.clear();
            set1.addAll(tempory);
            if (i < operator.size() - 1 && Boolean.TRUE.equals(verbose)) {
                Print.printResult(parse.get(i) + parse.get(i + 1) + parse.get(i + 2), tempory);
            }
            tempory.clear();
        }
    }

    @Override
    public Integer call() {
        try {
            statement = statement.toLowerCase();
            intence = BasicOperationSingelton.getIntence(getPremisCount(statement));
            if (Boolean.TRUE.equals(verbose))
                intence.getTableChart().forEach(Print::printResult);

            if (statement != null) {
                List<String> parse = ParseLogics.parseLogic(statement);

                if ((parse.size() % 2) != 0) {
                    Print.printResult(statement, iterateStatment(parse));
                } else {
                    System.err.println(new Exception("something wrong"));
                }
            }
        } catch (NullPointerException e) {
            System.out.println("something wrong");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    private String[] getPremisCount(String str) throws Exception {
        str = str.replace("(", "").replace(")", "").replace("~", "").trim();
        for (String iterable_element : Operators.OPERATOR) {
            str = str.replace(iterable_element, " ").trim();
        }
        checkIsCorrectStatment(str.split(" "));
        Set<String> result = new HashSet<>(List.of(str.split(" ")));
        return Arrays.copyOf(result.toArray(), result.size(), String[].class);
    }

    private void checkIsCorrectStatment(String[] str) throws Exception {
        Executors.newFixedThreadPool(Operators.NOT_OPERATOR.size());
        for (String iterable_element : Operators.NOT_OPERATOR) {
            for (String string : str) {
                if (string.contains(iterable_element)) {
                    throw new Exception("unCorrect Arguments");
                }
            }
        }
    }
}