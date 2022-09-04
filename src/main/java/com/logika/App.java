package com.logika;

import com.logika.controllers.LogicCaller;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "mathcli", description = "Operation logic", mixinStandardHelpOptions = true, version = "1.2", subcommands = {
        LogicCaller.class })
public class App implements Runnable {
    public static void main(String[] args) {
        System.gc();
        int execute = 0;
        execute = new CommandLine(new App()).execute(args);
        System.exit(execute);
    }

    @Override
    public void run() {

    }
}
