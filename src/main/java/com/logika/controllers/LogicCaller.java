package com.logika.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.logika.Constans.Constans;
import com.logika.helpers.logichelper.ParseLogics;
import com.logika.helpers.logichelper.Spliterators;
import com.logika.helpers.print.Print;
import com.logika.services.logicops.BasicOperation;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "lgc", description = "compare string logic to boolean", version = "1.0", mixinStandardHelpOptions = true)
public class LogicCaller implements Callable<Integer> {

    Spliterators spliterators = new Spliterators();

    @Option(names = { "-v", "--value" }, description = "value to compare string")
    private String statement;

    ExecutorService exe = Executors.newCachedThreadPool();

    /**
     * @param parse jika parse lebih dari 2
     * @return
     */
    public List<Boolean> iterateStatment(List<String> parse) {
        spliterators.setStatusR(parse.stream().anyMatch(item -> item.contains("r")));
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
                        component.add(r / 2,
                                exe.submit(() -> {
                                    return spliterators.spliters(parse.get(t));
                                }).get());
                    } else {
                        operator.add(parse.get(r));
                    }
                }
                set1.addAll(component.get(0));
                set2.addAll(component.get(1));
                for (int i = 0; i < operator.size(); i++) {
                    String oprs = operator.get(i);
                    if (oprs.equals(Constans.OPERATOR.get(0))) {
                        tempory.addAll(BasicOperation.andOps(set1, set2));
                    } else if (oprs.equals(Constans.OPERATOR.get(1))) {
                        tempory.addAll(BasicOperation.orOps(set1, set2));
                    } else if (oprs.equals(Constans.OPERATOR.get(2))) {
                        tempory.addAll(BasicOperation.impOps(set1, set2));

                    } else if (oprs.equals(Constans.OPERATOR.get(3))) {
                        tempory.addAll(BasicOperation.bimpOps(set1, set2));

                    } else {
                    }
                    set2.clear();
                    int y = 2;
                    try {
                        set2.addAll(component.get(y));
                        y++;
                    } catch (Exception e) {

                    }
                    set1.clear();
                    set1.addAll(tempory);
                    tempory.clear();
                }
                return set1;
            } else {
                return spliterators.spliters(parse.get(0));
            }
        } catch (Exception e) {
            // System.err.println(e + "ite");
            return null;
        }
    }

    @Override
    public Integer call() {
        statement = statement.toLowerCase();
        try {
            if (statement != null) {
                List<String> parse = ParseLogics.parseLogic(statement);
                if (parse.stream().anyMatch(item -> item.contains("r"))) {
                    this.spliterators.setStatusR(true);
                }
                if ((parse.size() % 2) != 0) {
                    this.printResult(statement, iterateStatment(parse));
                } else {
                    System.err.println(new Exception("something wrong"));
                }
            }
        } catch (Exception e) {
            System.err.println(e + " *`call");
        }
        System.out.println();
        return 1;
    }

    public void printResult(String prefix, Collection<Boolean> result) {
        String printed = String.format("| %s | %s |", prefix, result.toString().replace("[", "").replace("]", ""));
        int lenght = printed.length();
        Print.topBottom(lenght);
        System.out.println(printed);
        Print.topBottom(lenght);

    }

}