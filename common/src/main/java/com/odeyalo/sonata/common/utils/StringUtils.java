package com.odeyalo.sonata.common.utils;

public final class StringUtils {


    public static boolean containsOnlyLowercase(final CharSequence sequence) {
        // Do not use regex for performance reason
        for (int i = 0; i < sequence.length(); i++) {
            final char currentChar = sequence.charAt(i);

            if ( !(currentChar >= 'a' && currentChar <= 'z') ) {
                return false;
            }
        }
        return true;
    }
}
