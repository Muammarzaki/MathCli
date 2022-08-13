package com.logika.helpers.logichelper;

import com.logika.services.logicops.BasicOperation;

public class BasicOpsST {
    private static BasicOperation BasicOperation;

    public static BasicOperation getInstens() {
        if (BasicOperation == null) {
            BasicOperation = new BasicOperation();
        }
        return BasicOperation;
    }
}
