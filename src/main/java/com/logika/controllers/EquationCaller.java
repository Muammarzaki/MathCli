package com.logika.controllers;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "prs", description = "compare string logic to boolean", mixinStandardHelpOptions = true)
public class EquationCaller implements Callable<Integer> {

    @Parameters(type = String.class)
    public String inputEquation;

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
