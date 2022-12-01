package com.logika;

import com.logika.controllers.LogicCaller;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "mathcli", description = "Operation logic", mixinStandardHelpOptions = true, version = "1.2.5", subcommands = {
        LogicCaller.class })

public class App implements Runnable {
    public static void main(String[] args) {
        int execute;
        execute = new CommandLine(new App()).execute(args);
        if (execute > 0) {
            System.exit(execute);
        }
    }

    @Override
    public void run() {
        // nothing to do
    }
}
