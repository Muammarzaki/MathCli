package com.logika.controllers;

import java.security.spec.RSAPublicKeySpec;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import com.logika.constans.Operators;
import com.logika.helpers.logichelper.ParseLogics;
import com.logika.helpers.logichelper.Spliterators;
import com.logika.helpers.print.Print;
import com.logika.services.logicops.BasicOperation;
import com.logika.services.logicops.BasicOperationSingelton;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "lgc", description = "compare string logic to boolean", mixinStandardHelpOptions = true)
public class LogicCaller implements Callable<Integer> {

    Spliterators spliterators = new Spliterators();

    @Option(names = { "-v", "--value" }, description = "value to compare string")
    private String statement;

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
                        component.add(r / 2, spliterators.spliters(parse.get(t)));
                    } else {
                        operator.add(parse.get(r));
                    }
                }
                // set data 1 and data 2 to compare
                set1.addAll(component.get(0));
                set2.addAll(component.get(1));
                iterateToCompare(tempory, component, operator, set1, set2);
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
            List<Boolean> set1, List<Boolean> set2) {
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
            tempory.clear();
        }
    }

    @Override
    public Integer call() {
        statement = statement.toLowerCase();
        BasicOperationSingelton.getIntence(getPremiscoutn(statement));
        try {
            if (statement != null) {
                List<String> parse = ParseLogics.parseLogic(statement);

                if ((parse.size() % 2) != 0) {
                    this.printResult(statement, iterateStatment(parse));
                } else {
                    System.err.println(new Exception("something wrong"));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            return 1;
        }
        return 0;
    }

    /**
     * print hasil ke kosol
     * 
     * @param prefix
     * @param result
     */
    public void printResult(String prefix, Collection<Boolean> result) {
        String printed = String.format("| %s | %s |", prefix, result.toString().replace("[", "").replace("]", ""));
        int lenght = printed.length();
        Print.topBottom(lenght);
        System.out.println(printed);
        Print.topBottom(lenght);

    }

    private String[] getPremiscoutn(String str) {
        str = str.replace("(", "").replace(")", "").replace("~", "").trim();
        for (String iterable_element : Operators.OPERATOR) {
            str = str.replace(iterable_element, " ").trim();
        }
        Set<String> result = new HashSet<>(List.of(str.split(" ")));
        return Arrays.copyOf(result.toArray(), result.size(), String[].class);
    }
}