package com.logika.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.logika.Constans.Constans;
import com.logika.helpers.logichelper.ParseLogics;
import com.logika.helpers.logichelper.Spliterators;
import com.logika.services.logicops.BasicOperation;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "lgc", description = "compare string logic to boolean", version = "1.0", mixinStandardHelpOptions = true)
public class LogicCaller implements Callable<Integer> {
    Spliterators spliterators = new Spliterators();
    @Option(names = { "-v", "--value" }, description = "value to compare string")
    private String statement;

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
                for (int i = 0; i < parse.size(); i++) {
                    if ((i % 2) == 0) {
                        component.add(spliterators.spliters(parse.get(i)));
                    } else {
                        operator.add(parse.get(i));
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
        try {
            if (statement != null) {
                List<String> parse = ParseLogics.parseLogic(statement);
                if (parse.stream().anyMatch(item -> item.contains("r"))) {
                    this.spliterators.setStatusR(true);
                }
                if ((parse.size() % 2) != 0) {
                    System.out.println();
                    System.out.println(iterateStatment(parse));
                } else {
                    System.err.println(new Exception("something wrong"));
                }
            }
        } catch (Exception e) {
            System.err.println(e + " *`call");
        }
        return 1;
    }
}
