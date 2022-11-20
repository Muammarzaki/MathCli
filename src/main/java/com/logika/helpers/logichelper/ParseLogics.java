package com.logika.helpers.logichelper;

import java.util.ArrayList;
import java.util.List;

import com.logika.constans.Operators;

public class ParseLogics {

    /**
     * @param str
     * @return
     * @throws Exception
     */
    public static List<String> parseLogic(String str) {
        ParseLogics parse = new ParseLogics();
        List<String> slice = new ArrayList<>();
        while (true) {
            str = str.trim().replace(" ", "");
            int length = str.length();
            if (parse.checkStartWith(str)) {
                // jika string diawali oleh operator
                str.trim();
                slice.add(str.substring(0, 1));
                // mengembalikan string yg telah di potong
                str = str.substring(1);
            } else {
                if (!str.startsWith("~")) {
                    // jika string tidak diawali negasi
                    if (!str.startsWith("(")) {
                        // jik string tidak diawali ()
                        if (parse.getIndexOps(str) > 0 && str.indexOf("(") > 1) {
                            // jika didepan masih ada operator
                            slice.add(str.substring(0, parse.getIndexOps(str)));
                            // kembaliakan string
                            str = str.substring(parse.getIndexOps(str));
                        } else {
                            slice.add(str);
                        }
                    } else {
                        slice.add(str.substring(str.indexOf("("), str.indexOf(")") + 1));
                        str = str.substring(str.indexOf(")") + 1);
                    }
                } else if (str.startsWith("~")) {
                    // jika string diawali negasi
                    if (!str.substring(str.indexOf("~") + 1, str.indexOf("~") + 2).equals("(")) {
                        // jika tidak diawali kurung ()
                        if (parse.getIndexOps(str) >= 0 && str.indexOf("(") > 1) {
                            slice.add(str.substring(0, parse.getIndexOps(str)));
                            str = str.substring(parse.getIndexOps(str));
                        } else {
                            slice.add(str);
                        }
                    } else {
                        slice.add(str.substring(str.indexOf("(") - 1, str.indexOf(")") + 1));
                        str = str.substring(str.indexOf(")") + 1);
                    }
                } else {
                    System.out.println(new Exception("statment unknow"));
                }
            }
            if (str.length() >= length) {
                break;
            }

        }
        return slice.stream().filter(item -> !item.equals("")).toList();

    }

    public int getIndexOps(String str) {
        for (String item : Operators.OPERATOR) {
            if (str.indexOf(item) >= 0) {
                return str.indexOf(item);
            }
        }
        return -1;
    }

    public boolean checkStartWith(String str) {
        return Operators.OPERATOR.stream().anyMatch(item -> str.startsWith(item));
    }
}
