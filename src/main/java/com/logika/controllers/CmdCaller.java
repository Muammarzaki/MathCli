package com.logika.controllers;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;

@Command(name = "csv", helpCommand = true, description = "Operation logic", mixinStandardHelpOptions = true, version = "1.0", subcommands = {})
public class CmdCaller implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread());
        return null;
    }

}
