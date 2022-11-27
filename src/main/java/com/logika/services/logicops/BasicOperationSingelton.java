package com.logika.services.logicops;

public class BasicOperationSingelton {
    private static BasicOperation bsc;

    /**
     * 
     */
    private BasicOperationSingelton() {
        // nothing to do
    }

    public static BasicOperation getIntence(String... premis) {
        if (bsc == null) {
            bsc = new BasicOperation(premis);
        }
        return bsc;
    }
}
