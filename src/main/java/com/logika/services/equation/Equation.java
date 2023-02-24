package com.logika.services.equation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Equation {
    private String equestion;
    private Double[] root;

    /**
     * /.?([0-9]\w?\^?[0-9]?)/gm
     */
    public Equation() {
    }

    public Double[] getSolvers() {
        double numerator = Math.sqrt(Math.pow(root[1], 2) - 4 * root[0] * root[2]);
        double denominator = 2 * root[0];
        Double[] result = new Double[2];
        result[0] = (-1 * (root[1]) + numerator) / denominator;
        result[1] = (-1 * (root[1]) - numerator) / denominator;
        return result;
    }

    public void generalisEquation(String equeString) {
        splitEquetion(equeString).forEach(System.out::println);

        // TODO document why this method is empty
    }

    /**
     * @return the equestion
     */
    public String getEquestion() {
        return equestion;
    }

    /**
     * @param equestion the equestion to set
     */
    public void setEquestion(String equestion) {
        this.equestion = equestion;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Double[] root) {
        this.root = root;
    }

    /**
     * @return the root
     */
    public Double[] getRoot() {
        return root;
    }

    private List<String> splitEquetion(String equeString) {
        Pattern pattern = Pattern.compile("[+-/*]?(\\d+\\w*\\^?\\w*)");
        Matcher matcher = pattern.matcher(equeString);

        if (!equeString.matches("^([+-/*]?(\\d+\\w*\\^?\\w*))+$"))
            throw new PatternSyntaxException("patter no valid", pattern.toString(), -1);
        List<String> pers = new ArrayList<>();
        while (matcher.find()) {
            pers.add(matcher.group(0));
        }
        return pers;
    }

}
