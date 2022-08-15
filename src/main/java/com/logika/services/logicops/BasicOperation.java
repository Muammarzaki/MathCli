package com.logika.services.logicops;

import java.util.ArrayList;
import java.util.List;

public class BasicOperation {
    private List<Boolean> p = new ArrayList<>();
    private List<Boolean> q = new ArrayList<>();
    private List<Boolean> r = new ArrayList<>();
    private List<Boolean> pl1 = p;
    private List<Boolean> pl2 = q;
    private boolean containsR = false;

    public BasicOperation() {
        generate(false);
    }

    public BasicOperation(boolean containsR) {
        generate(containsR);
    }

    public void generate(boolean containsR) {
        this.containsR = containsR;
        if (this.containsR) {
            this.p.addAll(List.of(true, true, true, true, false, false, false, false));
            this.q.addAll(List.of(true, true, false, false, true, true, false, false));
            this.r.addAll(List.of(true, false, true, false, true, false, true, false));
        } else {
            this.p.addAll(List.of(true, true, false, false));
            this.q.addAll(List.of(true, false, true, false));
        }
    }

    public List<Boolean> getP() {
        return p;
    }

    public BasicOperation setP(List<Boolean> p) {
        this.p = p;
        return this;
    }

    public List<Boolean> getQ() {
        return q;
    }

    public BasicOperation setQ(List<Boolean> q) {
        this.q = q;
        return this;

    }

    public List<Boolean> getR() {
        return r;
    }

    public List<Boolean> getPl1() {
        return pl1;
    }

    public void setPl1(List<Boolean> pl1) {
        this.pl1 = pl1;
    }

    public List<Boolean> getPl2() {
        return pl2;
    }

    public void setPl2(List<Boolean> pl2) {
        this.pl2 = pl2;
    }

    public BasicOperation setR(List<Boolean> r) {
        this.r = r;
        return this;
    }

    public boolean isContainsR() {
        return containsR;
    }

    public void setContainsR(boolean containsR) {
        this.containsR = containsR;
    }

    /**
     * dan / AND
     * 
     * @return {true,false,false,false}
     */
    public List<Boolean> andOps() {
        return BasicOperation.andOps(this.pl1, this.pl2);
    }

    /**
     * atau / Or
     * 
     * @return
     */
    public List<Boolean> orOps() {

        return BasicOperation.orOps(this.pl1, this.pl2);
    }

    /**
     * Bimplikasi
     * 
     * @return
     */
    public List<Boolean> impOps() {
        return BasicOperation.impOps(this.pl1, this.pl2);
    }

    /**
     * @return
     */
    public List<Boolean> bimpOps() {
        return BasicOperation.bimpOps(this.pl1, this.pl2);
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> andOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add(p1.get(i) && p2.get(i));
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> orOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add(p1.get(i) || p2.get(i));
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> impOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                if (p1.get(i) == true && p2.get(i) == false) {
                    result.add(false);
                } else {
                    result.add(true);
                }
            }
        }

        return result;
    }

    /**
     * @param p1
     * @param p2
     * @return
     */
    public static List<Boolean> bimpOps(List<Boolean> p1, List<Boolean> p2) {
        List<Boolean> result = new ArrayList<>();
        if (p1.size() == p2.size()) {
            for (int i = 0; i < p1.size(); i++) {
                result.add(!(p1.get(i) != p2.get(i)));
            }
        }

        return result;
    }

}
