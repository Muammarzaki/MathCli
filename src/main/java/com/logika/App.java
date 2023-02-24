package com.logika;

import com.logika.controllers.EquationCaller;
import com.logika.controllers.LogicCaller;
import com.logika.controllers.PrimeCaller;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "mathcli", description = "Operation logic", mixinStandardHelpOptions = true, version = "\u001b[32mversion 1.2.5\u001b[00m", subcommands = {
        LogicCaller.class, EquationCaller.class, PrimeCaller.class })

public class App implements Runnable {
    public static void main(String... args) {
        int execute;
        execute = new CommandLine(new App()).execute(args);
        if (execute > 0) {
            System.exit(execute);
        }
    }

    @Override
    public void run() {
        App.main("--version");
        App.main("--help");
    }
}
