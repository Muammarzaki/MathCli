package com.logika.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "prm", description = "generating prime number", mixinStandardHelpOptions = true)
public class PrimeCaller implements Callable<Integer> {

    @Option(type = Integer.class, names = { "-r",
            "--range" }, defaultValue = "50", description = "set range generating prime number 0 to n")
    public Integer range;

    @Override
    public Integer call() throws Exception {
        int max = range;
        List<Integer> primeNumber = this.geratingPrimeNumber(max);
        System.out.println(primeNumber.toString());
        return 0;

    }

    public List<Integer> geratingPrimeNumber(int n) {
        Boolean[] primeBooleanSort = new Boolean[n];
        Arrays.fill(primeBooleanSort, true);
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (Boolean.TRUE.equals(primeBooleanSort[i])) {
                int j = (int) Math.pow(i, 2);
                while (j < n) {
                    primeBooleanSort[j] = false;
                    j += i;
                }
            }
        }
        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 0; i < primeBooleanSort.length; i++) {
            if (Boolean.TRUE.equals(primeBooleanSort[i])) {
                primeNumber.add(i);
            }
        }
        return primeNumber.stream().filter(x -> x >= 2).collect(Collectors.toList());
    }
}
