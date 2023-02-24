package com.logika.services.logicops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicOperation {
    private List<List<Boolean>> table = new ArrayList<>();
    private Map<String, List<Boolean>> tableChart = new HashMap<>();
    private List<Boolean> premis1;
    private List<Boolean> premis2;

    public BasicOperation(String... premis) {
        generate(premis);
    }

    public BasicOperation generate(String... chars) {
        try {
            generateLogicTable(chars.length, chars);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    private void generateLogicTable(Integer charCount, String... chars)
            throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService exe = Executors.newFixedThreadPool(charCount);

        for (int i = 0; i < charCount; i++) {
            table.add(Collections.emptyList());
            final int t = i;
            List<Boolean> premis = exe.submit(() -> generate(charCount, t)).get();
            table.set(i, premis);
            tableChart.put(chars[i], premis);
        }
        exe.awaitTermination(50, TimeUnit.MILLISECONDS);
        exe.shutdown();
    }

    private List<Boolean> generate(Integer size, Integer index) {
        Boolean titikBalik = true;
        Double perbesaran = Math.pow(2, size);
        List<Boolean> v = new ArrayList<>();
        for (int i = 1; i <= perbesaran; i++) {
            v.add(titikBalik);
            if (i % ((perbesaran / 2) / Math.pow(2, index)) == 0) {
                titikBalik = !titikBalik;
            }
        }
        return v;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> andOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add(p1.get(i) && p2.get(i));
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> orOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add(p1.get(i) || p2.get(i));
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> impOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                if (Boolean.TRUE.equals(p1.get(i)) && Boolean.TRUE.equals(p2.get(i) == Boolean.FALSE)) {
                    result.add(false);
                } else {
                    result.add(true);
                }
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> bimpOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add((Objects.equals(p1.get(i), p2.get(i))));
            }
        }

        return result;
    }

    /**
     * @return the table
     */
    public List<List<Boolean>> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(List<List<Boolean>> table) {
        this.table = table;
    }

    /**
     * @return the tableChart
     */
    public Map<String, List<Boolean>> getTableChart() {
        return tableChart;
    }

    /**
     * @param tableChart the tableChart to set
     */
    public void setTableChart(Map<String, List<Boolean>> tableChart) {
        this.tableChart = tableChart;
    }

    /**
     * @return the premis1
     */
    public List<Boolean> getPremis1() {
        return premis1;
    }

    /**
     * @param premis1 the premis1 to set
     */
    public void setPremis1(List<Boolean> premis1) {
        this.premis1 = premis1;
    }

    /**
     * @return the premis2
     */
    public List<Boolean> getPremis2() {
        return premis2;
    }

    /**
     * @param premis2 the premis2 to set
     */
    public void setPremis2(List<Boolean> premis2) {
        this.premis2 = premis2;
    }

}
