package com.logika.helpers.logichelper;

import java.util.Collections;
import java.util.List;

import com.logika.constans.Operators;
import com.logika.services.logicops.BasicOperation;
import com.logika.services.logicops.Negasi;

public class Spliterators {
    public BasicOperation basicOperation = new BasicOperation();
    private boolean statusR = false;

    public void setStatusR(boolean statusR) {
        this.statusR = statusR;
    }

    /**
     * @param statement
     * @return
     */
    public List<Boolean> findMethod(String statement) {
        basicOperation = new BasicOperation(this.statusR);
        statement = statement.toLowerCase();
        Exception exceptions = new Exception("error not statement please use [~,"
                + Operators.OPERATOR.toString().replace("[", "").replace("]", "") + ",p,q]");

        try {
            if (cleanString(statement).length() == 3) {
                setIndex(cleanString(statement));
            }
            if (basicOperation.getPl1() == null || basicOperation.getPl2() == null) {
                throw exceptions;
            }
            if (ifnegasi(statement)) {
                statement = cleanString(statement);
            }
            if (statement.length() == 3) {
                if (statement.contains(Operators.OPERATOR.get(0))) {
                    // AND
                    return basicOperation.andOps();
                } else if (statement.contains(Operators.OPERATOR.get(1))) {
                    // OR
                    return basicOperation.orOps();
                } else if (statement.contains(Operators.OPERATOR.get(2))) {
                    // IMPLIKASI
                    return basicOperation.impOps();
                } else if (statement.contains(Operators.OPERATOR.get(3))) {
                    // BIIMPLIKASI
                    return basicOperation.bimpOps();
                } else {
                    throw exceptions;
                }
            } else if (statement.length() == 1) {
                if (statement.equals("p")) {
                    return basicOperation.getP();
                } else if (statement.equals("q")) {
                    return basicOperation.getQ();
                } else if (statement.equals("r")) {
                    return basicOperation.getR();
                } else {
                    throw exceptions;
                }
            } else {
                throw new Exception("error not statement");
            }
        } catch (Exception e) {
            System.out.println(e);
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
    public Boolean ifnegasi(String str) {
        int index = str.indexOf("~");
        try {
            if (str.contains("~") && str.substring(index + 1, index + 2) != null
                    && !str.substring(index + 1, index + 2).equals("(")) {
                while (str.indexOf("~") > -1) {
                    singelNegasi(getbetween(str));
                    str = str.replaceFirst("~", "");
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e + "neg");
            return false;
        }

    }

    /**
     * @param str
     * @param index
     * @throws Exception
     */
    private void singelNegasi(String str) throws Exception {
        int index = str.indexOf("~");
        if (str.length() > 2) {
            if (index > -1 && index < 2) {
                this.basicOperation.setPl1(Negasi.negasi(this.basicOperation.getPl1()));
            } else if (index >= 2 && index < 4) {
                this.basicOperation.setPl2(Negasi.negasi(this.basicOperation.getPl2()));
            } else {
                throw new Exception("must be singel char");
            }
        } else if (str.length() < 3) {

            if (str.substring(index + 1, index + 2).equals("p")) {
                this.basicOperation.setP(Negasi.negasi(this.basicOperation.getP()));
            } else if (str.substring(index + 1, index + 2).equals("q")) {
                this.basicOperation.setQ(Negasi.negasi(this.basicOperation.getQ()));
            } else {
                throw new Exception("must be singel char");
            }
        } else {
            // nothing to do
        }
    }

    /**
     * @param str
     * @return
     */
    public String cleanString(String str) {
        return str.replace("~", "");
    }

    public void setIndex(String Statement) {
        String index1 = Statement.substring(0, 1);
        String index2 = Statement.substring(2);

        switch (index1) {
            case "p":
                basicOperation.setPl1(basicOperation.getP());
                break;
            case "q":
                basicOperation.setPl1(basicOperation.getQ());
                break;
            case "r":
                basicOperation.setPl1(basicOperation.getR());
                break;
            default:
                basicOperation.setPl1(null);
                break;
        }
        switch (index2) {
            case "p":
                basicOperation.setPl2(basicOperation.getP());
                break;
            case "q":
                basicOperation.setPl2(basicOperation.getQ());
                break;
            case "r":
                basicOperation.setPl2(basicOperation.getR());
                break;
            default:
                basicOperation.setPl2(null);
                break;
        }
    }
}