package com.logika.services.logicops;

import java.util.Arrays;
import java.util.List;

public class Negasi {

    /**
     * @param condition
     * @return
     */
    public static List<Boolean> negasi(List<Boolean> condition) {
        return condition.stream().map((item) -> item == false ? true : false).toList();
    }

    /**
     * @param condition
     * @return
     */
    public static Boolean negasi(Boolean condition) {
        return condition == false ? true : false;
    }

    public static List<Boolean> negasi(Boolean... condition) {
        return Arrays.asList(condition).stream().map((item) -> item == false ? true : false).toList();
    }
}
