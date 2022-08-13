package com.logika;

import com.logika.controllers.CmdCaller;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        System.gc();
        int execute = new CommandLine(new CmdCaller()).execute();
        System.exit(execute);
    }
}
