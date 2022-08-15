package com.logika.controllers;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;

@Command(name = "csv", description = "Operation logic", mixinStandardHelpOptions = true, version = "1.0", subcommands = {
        LogicCaller.class })
public class CmdCaller implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }

}
