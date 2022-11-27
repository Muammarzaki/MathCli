package com.logika.helpers.logichelper;

import java.util.Collections;
import java.util.List;

import com.logika.constans.Operators;
import com.logika.services.logicops.BasicOperation;
import com.logika.services.logicops.BasicOperationSingelton;
import com.logika.services.logicops.Negasi;

public class Spliterators {
    public BasicOperation basicOperation = BasicOperationSingelton.getIntence();

    /**
     * 
     */
    public Spliterators() {
        // nothing to do
    }

    Exception exceptions = new Exception("error not statement please use [~,"
            + Operators.OPERATOR.toString().replace("[", "").replace("]", "") + ",p,q]");

    /**
     * @param statement
     * @return
     */
    public List<Boolean> findMethod(String statement) {
        statement = statement.toLowerCase();
        String[] premis = getPremisAndOperator(statement);
        List<Boolean> premis1 = ifnegasi(premis[0]);
        List<Boolean> premis2 = ifnegasi(premis[1]);

        if (statement.contains(Operators.OPERATOR.get(0))) {
            return BasicOperation.andOps(premis1, premis2);
        } else if (statement.contains(Operators.OPERATOR.get(1))) {
            return BasicOperation.orOps(premis1, premis2);
        } else if (statement.contains(Operators.OPERATOR.get(2))) {
            return BasicOperation.impOps(premis1, premis2);

        } else if (statement.contains(Operators.OPERATOR.get(3))) {
            return BasicOperation.bimpOps(premis1, premis2);
        } else {
            System.out.println("ini error nya");
        }
        return Collections.emptyList();

    }

    public String getbetween(String v) {
        if (v.contains(")") && v.contains(")")) {
            v = v.substring(v.indexOf("(") + 1, v.indexOf(")"));
            return v.trim();
        } else {
            return v.trim();
        }
    }

    /**
     * [~(~p&q)]
     * 
     * @return
     */
    public List<Boolean> spliters(String v) {
        v.trim();
        if (v.contains("~") && v.substring(v.indexOf("~") + 1, v.indexOf("~") + 2).equals("(") && v.length() > 0) {
            return Negasi.negasi(this.findMethod(this.getbetween(v)));
        } else {
            return this.findMethod(this.getbetween(v));
        }

    }

    /**
     * @param str
     * @return
     */
    public List<Boolean> ifnegasi(String str) {
        if (str.contains("~")) {
            str.replace("~", "");
            return Negasi.negasi(basicOperation.getTableChart().get(str));
        } else {
            return basicOperation.getTableChart().get(str);
        }
    }

    /**
     * @param str
     * @return
     */
    public String cleanString(String str) {
        return str.replace("~", "");
    }

    public String[] getPremisAndOperator(String statement) {
        statement = getbetween(statement);
        for (String iterable_element : Operators.OPERATOR) {
            if (statement.contains(iterable_element)) {
                statement.replace(iterable_element, " ").trim();
            }
        }
        return statement.split(" ");
    }

}
