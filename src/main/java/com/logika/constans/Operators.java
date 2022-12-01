package com.logika.constans;

import java.util.List;

public class Operators {

    /**
     * and , or ,implikasi , bimplikasi
     */
    public static final List<String> OPERATOR = List.of("&", "|", "-", "#");
    public static final List<String> NOT_OPERATOR = List.of("!", "<", ">", "\'", "\"", "\\", "/", ")", "(", "*", "_",
            "^", "%", ".", "$", "@", "{", "}", "[", "]", ":", ";", "?");

    /**
     * 
     */
    private Operators() {
        // nothing to do
    }
}
