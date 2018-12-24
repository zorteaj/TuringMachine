package com.jzap.turingmachine;

public class Config {
    private static final String LOG_PREFIX = "Turing Machine: ";
    public static String getTag(String postfix) {
        return LOG_PREFIX + postfix;
    }
}
