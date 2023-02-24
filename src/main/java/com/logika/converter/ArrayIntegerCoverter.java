package com.logika.converter;

import java.util.Arrays;

import picocli.CommandLine;

public class ArrayIntegerCoverter implements CommandLine.ITypeConverter<Integer[]> {

    @Override
    public Integer[] convert(String arg0) throws Exception {
        String[] split = arg0.split(",");
        return Arrays.stream(split).map(Integer::parseInt).toArray(Integer[]::new);
    }

}
